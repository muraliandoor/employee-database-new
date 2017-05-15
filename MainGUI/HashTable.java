package MainGUI;

import java.util.*;

public class HashTable {

    int numItems;

    // buckets is an array of ArrayList.  Each item in an ArrayList is an EmployeeInfo object.
    public ArrayList<EmployeeInfo>[] buckets;

    // CONSTRUCTOR
    public HashTable(int howManyBuckets) {
        // Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

        // Instantiate an array to have an ArrayList as each element of the array.
        buckets = new ArrayList[howManyBuckets];

        // For each element in the array, instantiate its ArrayList.
        for (int i = 0; i < howManyBuckets; i++) {
            buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
        }
    }

    public int calcBucket(int keyValue) {
        // Returns the bucket number as the integer keyValue modulo the number of buckets for the hash table.
        return (keyValue % buckets.length);
    }

    public boolean addEmployee(EmployeeInfo theEmployee) {
        numItems++;
        return buckets[calcBucket(theEmployee.getEmployeeNumber())].add(theEmployee);
    }

    public int searchEmployee(int employeeNum) {
        int empIndex = -1;
        if (buckets[calcBucket(employeeNum)].isEmpty() == false) {
            for (int i = 0; i < buckets[calcBucket(employeeNum)].size(); i++) {
                if (employeeNum == buckets[calcBucket(employeeNum)].get(i).getEmployeeNumber()) {
                    empIndex = i;
                }
            }
        }
        return empIndex;
    }

    public EmployeeInfo removeEmployee(int employeeNum) {
        EmployeeInfo toRemove = null;
        if (searchEmployee(employeeNum) != -1) {
            toRemove = buckets[calcBucket(employeeNum)].get(searchEmployee(employeeNum));
            buckets[calcBucket(employeeNum)].remove(searchEmployee(employeeNum));
        }
        numItems--;
        return toRemove;
    }

    public void displayContents() {
        // Print the employee numbers for the employees stored in each bucket's ArrayList,
        // starting with bucket 0, then bucket 1, and so on.
        if (buckets.length != 0) {
            for (int x = 0; x < buckets.length; x++) {
                System.out.println("Bucket: " + x);
                for (int y = 0; y < buckets[x].size(); y++) {
                    System.out.println(buckets[x].get(y).getEmployeeNumber());
                    //debugging check
                    System.out.println(buckets[x].get(y).getFirstName());
                    System.out.println(buckets[x].get(y).getLastName());
                }
                System.out.println("");
            }
        }
    }

    public EmployeeInfo returnEmployee(int employeeNum) {

        if (searchEmployee(employeeNum) == -1) {
            return null;
            //returns null if there are no employees in the arraylist
        } else {
            //returns employee number by searching for the employee
            return buckets[calcBucket(employeeNum)].get(searchEmployee(employeeNum));
        }
    }
} // end class MyHashTable
