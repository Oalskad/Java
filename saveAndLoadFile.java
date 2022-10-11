   public static void savetoFile() throws IOException {
        FileWriter wr = new FileWriter(ProductFile);
        BufferedWriter buffer = new BufferedWriter(wr);
        try {
            for (Product x : productlist) {
                buffer.write(x.toString());
            }
        } catch (Exception e) {
        } finally {
            buffer.close();
            wr.close();
        }
    }

    public static void loadfromFile() {
        try {
            FileReader fr = new FileReader(ProductFile);
            BufferedReader buffer = new BufferedReader(fr);
            String details;
            while ((details = buffer.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String ProductID = stk.nextToken().toUpperCase();
                String ProductName = stk.nextToken();
                double Unitprice = Double.parseDouble(stk.nextToken());
                int Quantity = Integer.parseInt(stk.nextToken());
                String status = stk.nextToken();
                Product d = new Product(ProductID, ProductName, Unitprice, Quantity, status);
                productlist.add(d);
//                String ProductID, String ProductName, double UnitPrice, int Quantity, String status
            }
        } catch (Exception e) {
        }
    }
