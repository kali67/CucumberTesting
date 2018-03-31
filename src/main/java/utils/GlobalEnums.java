package utils;

class GlobalEnums {

    public enum Fuel {
        PETROL ("PETROL"),
        DIESEL ("DIESEL"),
        ELECTRIC ("ELECTRIC"),
        GAS ("GAS"),
        OTHER ("OTHER");

        private String value;

        Fuel(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }

        public static Enum getEnumFromString(String value) {
            try {
                return Fuel.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

    }

}
