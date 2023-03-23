package pro.sky.shop.model;


import java.util.Objects;

public class Storage {
    private String nameOfProduct;
    private Integer id;

    public Storage(Integer id,String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return nameOfProduct.equals(storage.nameOfProduct) && id.equals(storage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, id);
    }

    @Override
    public String toString() {
        return id + ": " + nameOfProduct;
    }
}