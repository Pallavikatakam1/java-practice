package com.questk2.main;

class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}

class InvalidCategoryException extends Exception {
    public InvalidCategoryException(String message) {
        super(message);
    }
}
