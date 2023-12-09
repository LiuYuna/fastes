package icu.agony.fastes.parser;

import icu.agony.fastes.builder.Configuration;
import icu.agony.fastes.builder.Connect;
import icu.agony.fastes.builder.MappingStatement;
import icu.agony.fastes.util.FileUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class XMLConfigurationParser {

    private XMLConfigurationParser() {}

    public static Configuration parse(InputStream is) throws Exception {
        Document document = new SAXReader().read(is);

        Element rootElement = document.getRootElement();

        Connect connect = parseConnect(rootElement);
        Map<String, MappingStatement> mappingStatementMap = parseMappingStatement(rootElement);

        return new Configuration(connect, mappingStatementMap);
    }

    private static Connect parseConnect(Element rootElement) {
        List<Node> propertyList = rootElement.selectNodes("/configuration/connect/property");

        Map<String, String> fields = new HashMap<>();

        for (Node propertyNode : propertyList) {
            Node key = propertyNode.selectSingleNode("@key");
            Node value = propertyNode.selectSingleNode("@value");
            fields.put(key.getStringValue(), value.getStringValue());
        }

        return new Connect(fields.get("url"), fields.get("username"), fields.get("password"));
    }

    private static Map<String, MappingStatement> parseMappingStatement(Element rootElement) throws DocumentException {
        Map<String, MappingStatement> result = new HashMap<>();
        for (Node mappingNode : rootElement.selectNodes("/configuration/mappings/mapping/@path")) {
            InputStream mis = FileUtil.gerResource(mappingNode.getStringValue());
            Map<String, MappingStatement> mappingStatementMap = XMLMappingParser.parse(mis);
            result.putAll(mappingStatementMap);
        }
        return result;
    }

}
