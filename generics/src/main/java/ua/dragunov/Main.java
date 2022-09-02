package ua.dragunov;

import ua.dragunov.agregation.AvgAggregator;
import ua.dragunov.agregation.CSVAggregator;
import ua.dragunov.agregation.DistinctAggregator;
import ua.dragunov.agregation.MaxAggregator;
import ua.dragunov.model.Customer;

public class Main {

    public static void main(String[] args) {
        DistinctAggregator<Integer> distinctAggregator = new DistinctAggregator<>();
        AvgAggregator<Integer> avgAggregator = new AvgAggregator<>();
        MaxAggregator<Integer> maxAggregator = new MaxAggregator<>();
        CSVAggregator<Customer> csvAggregator = new CSVAggregator<>();
        Customer[] customers = new Customer[] {new Customer("John", 23, Customer.Gender.MALE)
                , new Customer("Danylo", 21, Customer.Gender.MALE)
                , new Customer("Cassandra", 18, Customer.Gender.FEMALE)};
        Integer[] arr = {1, 1, 2, 3, 4, 5, 10, 121, 231, 231, 0, 0, 232};

        System.out.println(distinctAggregator.aggregate(arr));
        System.out.println(avgAggregator.aggregate(arr));
        System.out.println(maxAggregator.aggregate(arr));
        System.out.println(csvAggregator.aggregate(customers));
    }
}
