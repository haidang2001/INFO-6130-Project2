package jlin2.examples.localtesting

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for the EmailValidator class.
 * Tests the isValidEmail() method with various email formats.
 */
class EmailValidatorTest {

    @Test
    fun testValidEmailFormat() {
        // Test correct email address format
        val validEmail = "123@abc.com"
        assertTrue("Valid email format should return true", EmailValidator.isValidEmail(validEmail))
    }

    @Test
    fun testValidEmailWithSubdomain() {
        // Test correct email address with subdomain format
        val validEmailWithSubdomain = "123@abc.co.ca"
        assertTrue("Valid email with subdomain should return true", EmailValidator.isValidEmail(validEmailWithSubdomain))
    }

    @Test
    fun testInvalidEmailIncorrectDomain() {
        // Test incorrect email address format (incorrect domain)
        val invalidEmail = "123@abc"
        assertFalse("Invalid email with incorrect domain should return false", EmailValidator.isValidEmail(invalidEmail))
    }

    @Test
    fun testInvalidEmailWithDoubleDots() {
        // Test incorrect email address format (with double dots)
        val invalidEmailWithDoubleDots = "123@abc..com"
        assertFalse("Invalid email with double dots should return false", EmailValidator.isValidEmail(invalidEmailWithDoubleDots))
    }

    @Test
    fun testInvalidEmailWithoutUsername() {
        // Test incorrect email address format (without username)
        val invalidEmailWithoutUsername = "@abc.com"
        assertFalse("Invalid email without username should return false", EmailValidator.isValidEmail(invalidEmailWithoutUsername))
    }

    @Test
    fun testInvalidEmailWithoutDomain() {
        // Test incorrect email address format (without domain)
        val invalidEmailWithoutDomain = "testing123"
        assertFalse("Invalid email without domain should return false", EmailValidator.isValidEmail(invalidEmailWithoutDomain))
    }

    @Test
    fun testInvalidEmailEmptyString() {
        // Test incorrect email address format (empty string)
        val emptyEmail = ""
        assertFalse("Empty string should return false", EmailValidator.isValidEmail(emptyEmail))
    }

    @Test
    fun testInvalidEmailNull() {
        // Test incorrect email address format (null)
        val nullEmail: String? = null
        assertFalse("Null email should return false", EmailValidator.isValidEmail(nullEmail))
    }
} 