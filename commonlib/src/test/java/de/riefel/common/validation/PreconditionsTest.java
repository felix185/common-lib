package de.riefel.common.validation;

import de.riefel.common.errorhandling.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests {@link Preconditions}.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
class PreconditionsTest {

   @Test
   void checkNotNull_notNull_shouldReturnReference() {
       final String expected = "TEST";
       final String actual = Preconditions.checkNotNull(expected, "any error message");
       assertEquals(expected, actual);
   }

   @Test
   void checkNotNull_nullReference_shouldThrowBusinessException() {
       assertThrows(BusinessException.class, () -> Preconditions.checkNotNull(null, "any error message"));
   }
}