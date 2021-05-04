package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LicenseKeyFormatterSimpleTest {

  @Test
  void shouldSplitIntoTwoFullGroups() {
    assertEquals("5F3Z-2E9W", new LicenseKeyFormatter().formatSimple("5F3Z-2e-9-w", 4));
  }

  @Test
  void shouldHaveFirstPartShorter() {
    assertEquals("2-5G-3J", new LicenseKeyFormatter().formatSimple("2-5g-3-J", 2));
  }

  @Test
  void trickyPart() {
    assertEquals("AA-AA", new LicenseKeyFormatter().formatSimple("--a-a-a-a--", 2));
  }
}