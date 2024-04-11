package org.example.abstraction;

import static org.junit.jupiter.api.Assertions.*;

class EmailAdresseTest {
    @org.junit.jupiter.api.Test
    void gültigeEmailAdresse() {
        String email = "john-doe@hotmail.com";

        EmailAdresse emailAdresse = new EmailAdresse(email);

        assertEquals("john-doe@hotmail.com", emailAdresse.email());
    }

    @org.junit.jupiter.api.Test
    void ungültigeEmailAdresse() {
        String email1 = "john-doe@hotmail";
        String email2 = "john-doe@hotmail.";
        String email3 = "john-doe@123";
        String email4 = "123";
        String email5 = "@hotmail.com";

        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email1));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email2));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email3));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email4));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email5));
    }

    @org.junit.jupiter.api.Test
    void leereEmailAdresse() {
        String email = "";

        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email));
    }

    @org.junit.jupiter.api.Test
    void nullEmailAdresse() {
        String email = null;

        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email));
    }

    @org.junit.jupiter.api.Test
    void emailAdresseMitLeerzeichen() {
        String email = "john doe@gmail.com";

        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(email));
    }
}