package icu.agony.fastes.builder;

import icu.agony.fastes.mapping.MappingExecutor;
import icu.agony.fastes.parser.XMLConfigurationParser;

import java.io.InputStream;

public final class MappingExecutorBuilder {

    public static MappingExecutor build(InputStream is) {
        try {
            Configuration configuration = XMLConfigurationParser.parse(is);
            return new MappingExecutor(configuration);
        } catch (Exception e) {
            throw new RuntimeException("解析配置失败", e);
        }
    }

}
