package utils;

class GlobalEnums {

    /**
     * Enum for fuel type of a vehicle
     */
    public enum Fuel {
        PETROL,
        DIESEL,
        ELECTRIC,
        GAS,
        OTHER;

        /**
         * Gets the fuel enum from a string value
         * @param value - string value of the enum to be returned
         * @return - fuel enum if valid string is passed in or null
         */
        public static Enum getEnumFromString(String value) {
            try {
                return Fuel.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null; // return null if getting the value of fails
            }
        }

    }

}
