
COMPANY: CODETECH IT SOLUTIONS  

NAME: CHANDAN JAIWANT GOUDA

INTERN ID: CT04DF2793 

DOMAIN: JAVA PROGRAMMING  

DURATION: 4 WEEKS  

MENTOR: NEELA SANTHOSH KUMAR 


DESCRIPTION: For Task-4 of the CODTECH internship, the objective was to create an AI-based Recommendation System using Java and libraries like Apache Mahout. The goal was to develop a Java-based program capable of analyzing user preferences and recommending items accordingly, mimicking the systems used by platforms like Amazon, Netflix, or Spotify.

This task demanded an understanding of machine learning principles, collaborative filtering algorithms, and open-source data science libraries that can be integrated into Java applications.


---

🛠️ Tools and Libraries Used

1. Java SE (Standard Edition)

Java was used as the primary programming language due to its flexibility, readability, and support for third-party libraries. The basic implementation involved user-item matrices and collaborative filtering logic, which are central to recommender systems.

2. Apache Mahout

Apache Mahout is an open-source machine learning library primarily used for building scalable recommendation engines. Though Mahout is now more focused on Scala, its earlier versions provided strong Java support and utilities like:

DataModel for reading user preferences from a file.

UserSimilarity and UserNeighborhood for collaborative filtering.

Recommender interface to generate item suggestions.


3. BlueJ IDE

BlueJ was used for writing and testing the Java code. BlueJ’s simplified interface is perfect for modular programming and visualizing object-oriented structures. It also allows us to observe terminal outputs and run test cases easily.


---

📊 Methodology and Logic Used

The project was divided into two phases:

🔹 Phase 1: Simple Java-Based Recommender (Custom Implementation)

We implemented a basic user-based collaborative filtering algorithm without using any external libraries. This included:

Creating a user-item preference matrix using Map<String, Map<String, Integer>>.

Calculating similarity scores between users based on common rated items.

Scoring unseen items for the target user using these similarities.

Recommending the highest-rated unseen items.


This approach was useful for understanding the mechanics of recommendation engines before using a framework like Apache Mahout.

🔹 Phase 2: Apache Mahout Integration (Optional for Advanced Users)

For those who installed Apache Mahout and Hadoop-compatible environments, a more robust recommendation system was created using Mahout’s GenericUserBasedRecommender class. Mahout supports both user-based and item-based collaborative filtering, with support for loading data from a CSV file or database.

A sample Mahout-based snippet:

DataModel model = new FileDataModel(new File("dataset.csv"));
UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
List<RecommendedItem> recommendations = recommender.recommend(1, 2);


---

📚 Sources Used

✅ Official Sources:

1. Oracle Java Documentation
https://docs.oracle.com/javase
Used for syntax, API methods, and understanding data structures.


2. Apache Mahout Documentation
https://mahout.apache.org
Helped integrate Mahout-based recommendation logic into Java programs.



✅ Open-Source Platforms and Learning Portals:

3. GeeksforGeeks
Explained concepts like collaborative filtering, similarity metrics, and recommender system design.


4. Stack Overflow
Helped in resolving errors while reading datasets or integrating Apache Mahout in a Java environment.


5. GitHub
Referenced a few open-source Java recommender projects to understand implementation patterns, folder structure, and best practices.




---

🤖 Role of ChatGPT

ChatGPT played a significant supporting role in:

Clarifying the types of recommendation engines (user-based vs item-based).

Explaining similarity metrics (cosine, Pearson correlation).

Generating clean and readable code templates.

Providing suggestions for structuring the project in BlueJ.

Helping debug errors and optimize the logic for better readability and performance.


The final version of the Java code (provided earlier) was refined with the assistance of ChatGPT’s step-by-step suggestions, ensuring correctness and modularity.


---

📦 Output and Deliverable

The output of the recommendation system shows a list of recommended items for a given user based on their similarity to others in the dataset. For example, if Alice hasn't rated Item4, but similar users like Bob or Charlie rated it highly, it will be recommended to Alice.


OUTPUT: ![Output](T4.png)

