Test case:
a. Navigate to https://www.united.com
b. Fill the search criteria:
i. One-way flight
ii. From “New York JFK” to “Miami, FL, US (MIA - All Airports)”
iii. Depart date August 20th
iv. Economy class
c. Click Find flights
d. In the flight table:
i. Sort the flights by Economy (Most Restricted), lowest price first
ii. Collect Depart, Arrive, Stops, Duration, Price (Economy (Most Restricted)
price only) data in a json object.
iii. If the flight is not available for Price criteria: (Economy (Most Restricted),
filter the flight data out of the json object
iv. Print the final json object in the console.

How to run:
1. You ll need chromedriver.
2. Run with "maven clean test" command.
