package org.ntutssl.organization;

public class OrganizationException extends RuntimeException {
  public static final long serialVersionUID = 1L;

  public OrganizationException(String errorMessage) {
    super(errorMessage);
  }
}