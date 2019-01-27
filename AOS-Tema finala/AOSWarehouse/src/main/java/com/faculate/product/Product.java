package com.faculate.product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "warehouse")
public class Product {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long idProduct;

	    @Column(name="amount")
	    private int amount;
	    @Column(name="name")
	    private String name;
	    @Column(name="region")
	    private String region;


		public Product() {
	    }

	    public Product(int amount, String name, String region) {
	        this.amount = amount;
	        this.name = name;

	        this.region=region;
	    }

	    public long getId() {
	        return idProduct;
	    }

	    public void setId(int id) {
	        this.idProduct = id;
	    }

	    public int getAmount() {
	        return amount;
	    }

	    public void setAmount(int amount) {
	        this.amount = amount;
	    }
         

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Product store = (Product) o;
	        return idProduct == store.idProduct &&
	                amount == store.amount &&
	                Objects.equals(name, store.name) &&
	                Objects.equals(region, store.region);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idProduct, amount, name, region);
	    }

	    @Override
	    public String toString() {
	        return "Product{" +
	                "id=" + idProduct +
	                ", amount=" + amount +
	                ", product='" + name + '\'' +
	                ", region='" + region + '\'' +
	                '}';
	    }
}
