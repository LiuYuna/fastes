package icu.agony.fastes.parser;

import icu.agony.fastes.builder.MappingStatement;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class XMLMappingParser {

    private XMLMappingParser() {}

    public static Map<String, MappingStatement> parse(InputStream is) throws DocumentException {
        Document document = new SAXReader().read(is);

        Element rootElement = document.getRootElement();

        Map<String, MappingStatement> result = new HashMap<>();

        Attribute namespace = (Attribute) rootElement.selectSingleNode("@namespace");
        for (Node mappingNode : rootElement.selectNodes("/mappings/mapping")) {

            Node id = mappingNode.selectSingleNode("@id");
            Node method = mappingNode.selectSingleNode("@method");
            Node api = mappingNode.selectSingleNode("@api");
            Node index = mappingNode.selectSingleNode("@index");
            String requestBody = mappingNode.getStringValue();

            MappingStatement mappingStatement = new MappingStatement(id.getStringValue(), index.getStringValue(), method.getStringValue(), api.getStringValue(), requestBody.replaceAll("\\s", ""));
            String statementId = namespace.getStringValue() + "#" + id.getStringValue();

            result.put(statementId, mappingStatement);
        }

        return result;
    }

}
