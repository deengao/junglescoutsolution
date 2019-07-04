# junglescout_solution

Question:

Given an Amazon product ASIN (a unique identifier amazon uses for its products), build an application that can fetch the category, rank & product dimensions of that product on Amazon, store that data in some sort of database, and display the data on the front-end. For example, the details for ASIN "B002QYW8LW" can be found here www.amazon.com/dp/B002QYW8LW .

PS. You're probably going to think the best solution for the challenge would be to use Amazon's Product API & you're right - but registering for that is a mission! The API isn't available and you will need to figure out an alternative method :)


High Level Solution: 
Since using Amazon Product Advertising API requires applying amazon affiliate first, and it required human validation in the process, it could not use API to fetch amazon product information. Other way to fetch the information from Amazon is using web scrapper. This repo includes the solution of a backend java spring boot app and a frontend angular app. 

<a href="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-02+at+10.17.16+PM.png"> Architecture Diagram 
  <img src="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-02+at+10.17.16+PM.png"> 
</a>


The backend app is responsible fetching product information given a ASIN, the frontend serves as the user input and product information display purpose. 

Screen Capture:

<a target="_blank" href="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.18+AM.png"> user input product page
  <img src="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.18+AM.png"> 
</a>

<a target="_blank" href="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.27+AM.png"> product fetch display
  <img src="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.27+AM.png"> 
</a>

<a target="_blank" href="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.37+AM.png"> Product List page (support sort)
  <img src="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Screenshot+2019-07-03+at+10.34.37+AM.png"> 
</a>

<a target="_blank" href="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Jul-03-2019+10-42-24.gif"> Flow Capture
  <img src="https://s3-us-west-2.amazonaws.com/cloudsms.assets/me/Jul-03-2019+10-42-24.gif"> 
</a>

Other Questions: 
a. What were the biggest challenges you faced in writing the challenge?
  1. I have explored the Amazon Product Advertising API, the application to using API process requires to be first accepted   into the Associates Program and it is locale specific. The documentations are not straight formward. 
  2. Using web scrapping to fetch information from Amazon is chanllenging, the scrapping logic is somehow coupled with the layout of the product page, and requires some text engineering, though not NLP level. Writing a high reuable scrapping logic is needed.
  3. How can the product information keep updated with the amazon information itself. (by using some background job to periodically check again checksum)
  4. Consider performance(caching) and scaling(horizontal) requirement. 
 
b. Can you explain your thought process on how you solved the problem, and what iterations you went through to get to this solution?
  1. Indentify to use the web scrapping to fetch product information from Amazon
  2. Design the scapping logic by normalizing different kinds product pages layout and text
  3. Design the data flow and key components of the overall app. 
  4. Implement the design and fine-tune (added cache layer in backend app)

c. If you had to scale this application to handle millions of people adding in ASIN's in a given day, what considerations would you make?
  1. Infrastrcutre consideration: include load balancer 
  2. App consider: the backend app is stateless app, can be easily scale horizontally (docker&kubernetes), include cache layer
     add ASIN will access data layer as : cache -> db -> amazon  
  3. Database consideration: Master-Master or Multi-Master scaling 

d. Why did you choose the technologies you used?
  1. Spring boot as backend make it easy to create Spring-powered, production-grade applications and services, ORM, MVC are gifts
  2. Angular create a clean component-based frontend architecture with cli support and well community.



 ToDo:
 1. Implement the backend batch job (daily) fetch , compare and update product information
 2. Assumming amazon product page layout styles is finite. The web srapping logic further fine-tine from rule-based to data driven style, normalize the layout categories and introduce human loop if extraction face exception. So that the web scrapping logic will try analyze the new page layout and decide what scrapping strategy to use. 
 3. Deployment to Cloud  
