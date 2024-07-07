package edu.meninocoiso.collection.set.search.exercise1;

import java.util.Objects;

public class Contact {
	private String name;
	private String phone;

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Contact contact)) return false;
		return Objects.equals(getPhone(), contact.getPhone());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getPhone());
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + "]";
	}
}
