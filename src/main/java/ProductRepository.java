public class ProductRepository {
    protected Product[] items = new Product[0];

    public void add(Product item) {
        Product[] tmp  = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++ ) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void DeleteById(int id) {
        Product[] tmp  = new Product[items.length - 1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index += 1;
            }
        }
        items = tmp;
    }

}