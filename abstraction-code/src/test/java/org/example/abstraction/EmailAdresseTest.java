package org.example.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAdresseTest {
    @org.junit.jupiter.api.Test
    void gültigeEmailAdresse() {
        // Arrange
        String email = "john-doe@hotmail.com";

        // Act
        EmailAdresse emailAdresse = new EmailAdresse(email);

        // Assert
        assertEquals("john-doe@hotmail.com", emailAdresse.email());
    }

    @org.junit.jupiter.api.Test
    void ungültigeEmailAdresse() {
        // Arrange
        String emailOhneDomainendung = "john-doe@hotmail";
        String emailOhneDomainendungMitPunkt = "john-doe@hotmail.";
        String emailZahlStattDomain = "john-doe@123";
        String nurDieZahl123 = "123";
        String atZeichenUndDomain = "@hotmail.com";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(emailOhneDomainendung));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(emailOhneDomainendungMitPunkt));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(emailZahlStattDomain));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(nurDieZahl123));
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(atZeichenUndDomain));
    }

    @org.junit.jupiter.api.Test
    void leereEmailAdresse() {
        // Arrange
        String leereEingabe = "";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(leereEingabe));
    }

    @org.junit.jupiter.api.Test
    void nullEmailAdresse() {
        // Arrange
        String nullEmail = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> new EmailAdresse(nullEmail));
    }

    @org.junit.jupiter.api.Test
    void emailAdresseMitLeerzeichen() {
        // Arrange
        String emailMitLeerzeichen = "john doe@gmail.com";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new EmailAdresse(emailMitLeerzeichen));
    }
}