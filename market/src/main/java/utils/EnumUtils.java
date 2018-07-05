package utils;

import java.util.Optional;

public class EnumUtils {
        /**
         * This static method allow to validate an Enum value and return an Optional of it
         * @param enumType
         * @param value
         * @param <T>
         * @return
         */
        public static <T extends Enum<T>> Optional<T> valueOf(Class<T> enumType, String value) {
            T enumValue = null;
            try {
                enumValue = Enum.valueOf(enumType, value);
            } catch (IllegalArgumentException e) {
                LoggerDecorator.logger.error("Unsupported enum value");
            }
            return Optional.ofNullable(enumValue);
        }
    }