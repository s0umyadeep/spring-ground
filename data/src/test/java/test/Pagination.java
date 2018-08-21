package test;

public class Pagination {

    public static void main(String[] agrs) throws Exception {
        int[] query1 = new int[]{11, 12, 13, 14};
        int[] query2 = new int[]{21, 22, 23, 24, 25};
        //int[] query3 = new int[]{31, 32, 33, 34};
        int[] query3 = new int[]{};
        int[] query4 = new int[]{41, 42, 43, 44};

        Object[] results = {query1, query2, query3, query4};
        int page = 5;
        int itemsPerPage = 2;
        int[] items = listItemsPerPage(results, page, itemsPerPage);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }

    }

    private static int[] listItemsPerPage(Object[] results, int page, int itemsPerPage) {
        int[] output = new int[itemsPerPage];
        int availableItemsPerPage = itemsPerPage;
        int offset = (page - 1) * itemsPerPage;
        int numberOfRowsVisited = 0;

        for (Object result : results) {
            int[] query = (int[]) result;
            int rows = query.length;
            numberOfRowsVisited = numberOfRowsVisited + rows;
            if (numberOfRowsVisited <= offset) {
                continue;
            }
            int[] range = limit(query, numberOfRowsVisited, offset, availableItemsPerPage);
            for (int i = range[0]; i < range[0] + range[1]; i++) {
                if (availableItemsPerPage <= 0) {
                    break;
                }
                output[itemsPerPage - availableItemsPerPage] = query[i];
                availableItemsPerPage--;
            }
            if (availableItemsPerPage <= 0) {
                break;
            }
        }
        return output;
    }

    private static int[] limit(int[] query, int numberOfRowsVisited,
                               int offset, int availableItems) {
        int[] limit = new int[2];
        limit[0] = Math.max(offset - (numberOfRowsVisited - query.length), 0);
        limit[1] = Math.min(availableItems, query.length - limit[0]);
        return limit;
    }

}
