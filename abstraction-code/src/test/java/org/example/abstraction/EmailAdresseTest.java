package org.example.abstraction;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAdresseTest {
    @org.junit.jupiter.api.Test
    void gültigeEmailAdresse() {
        // Arrange
        String gültigeEmailAdresse = "john-doe@hotmail.com";

        // Act
        EmailAdresse emailAdresse = new EmailAdresse(gültigeEmailAdresse);

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

        // Act
        Executable emailOhneDomainendungErzeugen = () -> new EmailAdresse(emailOhneDomainendung);
        Executable emailOhneDomainendungMitPunktErzeugen = () -> new EmailAdresse(emailOhneDomainendungMitPunkt);
        Executable emailZahlStattDomainErzeugen = () -> new EmailAdresse(emailZahlStattDomain);
        Executable emailAusDerZahl123Erzeugen = () -> new EmailAdresse(nurDieZahl123);
        Executable emailAusAtDomainErzeugen = () -> new EmailAdresse(atZeichenUndDomain);

        // Assert
        assertThrows(IllegalArgumentException.class, emailOhneDomainendungErzeugen);
        assertThrows(IllegalArgumentException.class, emailOhneDomainendungMitPunktErzeugen);
        assertThrows(IllegalArgumentException.class, emailZahlStattDomainErzeugen);
        assertThrows(IllegalArgumentException.class, emailAusDerZahl123Erzeugen);
        assertThrows(IllegalArgumentException.class, emailAusAtDomainErzeugen);
    }

    @org.junit.jupiter.api.Test
    void leereEmailAdresse() {
        // Arrange
        String leereEingabe = "";

        // Act
        Executable leereEmailAdresseErzeugen = () -> new EmailAdresse(leereEingabe);

        // Assert
        assertThrows(IllegalArgumentException.class, leereEmailAdresseErzeugen);
    }

    @org.junit.jupiter.api.Test
    void nullEmailAdresse() {
        // Arrange
        String nullEmail = null;

        // Act
        Executable emailAdresseAusNullErzeugen = () -> new EmailAdresse(nullEmail);

        // Assert
        assertThrows(NullPointerException.class, emailAdresseAusNullErzeugen);
    }

    @org.junit.jupiter.api.Test
    void emailAdresseMitLeerzeichen() {
        // Arrange
        String emailMitLeerzeichen = "john doe@gmail.com";

        // Act
        Executable emailMitLeerzeichenErzeugen = () -> new EmailAdresse(emailMitLeerzeichen);

        // Assert
        assertThrows(IllegalArgumentException.class, emailMitLeerzeichenErzeugen);
    }
}
