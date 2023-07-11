package utils;

import enums.Type;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class BufferContext {
    private static final Logger LOG = LogManager.getLogger(BufferContext.class);

    private static final Map<Type, String> CONTEXT_MAP = new HashMap<>();

    public static void setContext(final Type key, final String value) {
        CONTEXT_MAP.put(key, value);
        LOG.info("put {} : {}", key, value);
    }

    public static String getContext(final Type key) {
        LOG.info("get {}", key);
        return CONTEXT_MAP.get(key);
    }
}
