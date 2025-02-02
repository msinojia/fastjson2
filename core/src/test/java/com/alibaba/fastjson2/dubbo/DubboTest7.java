package com.alibaba.fastjson2.dubbo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.DateUtils;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DubboTest7 {
    @Test
    public void test() {
        Date object = new Date();
        byte[] jsonbBytes = JSONB.toBytes(object, JSONWriter.Feature.WriteClassName,
                JSONWriter.Feature.FieldBased,
                JSONWriter.Feature.ErrorOnNoneSerializable,
                JSONWriter.Feature.ReferenceDetection,
                JSONWriter.Feature.WriteNulls,
                JSONWriter.Feature.NotWriteDefaultValue,
                JSONWriter.Feature.NotWriteHashMapArrayListClassName,
                JSONWriter.Feature.WriteNameAsSymbol);
        String str = JSONB.parseObject(
                jsonbBytes, String.class, JSONReader.Feature.SupportAutoType,
                JSONReader.Feature.UseDefaultConstructorAsPossible,
                JSONReader.Feature.ErrorOnNoneSerializable,
                JSONReader.Feature.UseNativeObject,
                JSONReader.Feature.FieldBased
        );
        assertEquals(DateUtils.toString(object), str);
    }

    @Test
    public void test1() {
        Bean object = new Bean();
        object.id = 1001;
        byte[] jsonbBytes = JSONB.toBytes(object, JSONWriter.Feature.WriteClassName,
                JSONWriter.Feature.FieldBased,
                JSONWriter.Feature.ErrorOnNoneSerializable,
                JSONWriter.Feature.ReferenceDetection,
                JSONWriter.Feature.WriteNulls,
                JSONWriter.Feature.NotWriteDefaultValue,
                JSONWriter.Feature.NotWriteHashMapArrayListClassName,
                JSONWriter.Feature.WriteNameAsSymbol);
        String str = JSONB.parseObject(
                jsonbBytes, String.class, JSONReader.Feature.SupportAutoType,
                JSONReader.Feature.UseDefaultConstructorAsPossible,
                JSONReader.Feature.ErrorOnNoneSerializable,
                JSONReader.Feature.UseNativeObject,
                JSONReader.Feature.FieldBased
        );
        assertEquals(JSON.toJSONString(object), str);
    }

    public static class Bean
            implements Serializable {
        public int id;
    }
}
