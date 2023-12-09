package icu.agony.fastes.builder;

import java.util.Map;

public class Configuration {

    private Connect connect;

    private Map<String, MappingStatement> mappingStatementMap;

    public Configuration(Connect connect, Map<String, MappingStatement> mappingStatementMap) {
        this.connect = connect;
        this.mappingStatementMap = mappingStatementMap;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public Map<String, MappingStatement> getMappingStatementMap() {
        return mappingStatementMap;
    }

    public void setMappingStatementMap(Map<String, MappingStatement> mappingStatementMap) {
        this.mappingStatementMap = mappingStatementMap;
    }
}
