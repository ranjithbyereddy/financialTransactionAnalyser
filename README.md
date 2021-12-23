# financialtransactionAnalyser

The repository consists of

1. pom.xml: Maven build file
2.Source code 
3.Jar file
## Build

### System/Tool requirements

1. Java 8

### Step

#### Build the project with maven

```
mvn clean install
```

A final jar file, named "FinancialRecordAnalyser.jar" produced in target/ (a built version is also available in /target

## Run

The program expects exactly 3 inputs:
 1. accountId of interest (e.g ACC334455, ACC778899)
 2. Start date (strictly in "dd/MM/yyyy HH:mm:ss" format)
 3. End date (strictly in "dd/MM/yyyy HH:mm:ss" format)

Run with the following command:

```
java -jar <path/to/FinancialRecordAnalyser> <accountId> <start_date> <end_date>
```

For example, in the root folder:

```
java -jar FinancialRecordAnalyser.jar "ACC334455" "20/10/2018 12:00:00" "20/10/2018 19:00:00"
```

Output:

```
Number of transactions included is:1
Relative balance for the period is: -25.00
```
