# junglescout_solution

Question:

Given an Amazon product ASIN (a unique identifier amazon uses for its products), build an application that can fetch the category, rank & product dimensions of that product on Amazon, store that data in some sort of database, and display the data on the front-end. For example, the details for ASIN "B002QYW8LW" can be found here www.amazon.com/dp/B002QYW8LW .

PS. You're probably going to think the best solution for the challenge would be to use Amazon's Product API & you're right - but registering for that is a mission! The API isn't available and you will need to figure out an alternative method :)


Solution: 
Since using AWSECommerceService developer api requires applying amazon affiliate first, and it required human validation in the process, it could not use API to fetch amazon product information. Other way to fetch the information from Amazon is using web scrapper. This repo includes the solution of a backend java spring boot app and a frontend angular app. 

The backend app is responsible fetching product information given a ASIN, the frontend serves as the user input and product information display purpose. 
