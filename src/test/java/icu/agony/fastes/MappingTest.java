package icu.agony.fastes;

import icu.agony.fastes.builder.MappingExecutorBuilder;
import icu.agony.fastes.mapping.MappingExecutor;
import icu.agony.fastes.util.FileUtil;
import org.junit.Test;

import java.io.InputStream;

public class MappingTest {


    @Test
    public void queryAll() {
        InputStream is = FileUtil.gerResource("fastes-config.xml");
        MappingExecutor mappingExecutor = MappingExecutorBuilder.build(is);
        String result = mappingExecutor.execute("icu.agony.fastes.TestMapping#queryAll");
        System.out.println(result);
    }

}
