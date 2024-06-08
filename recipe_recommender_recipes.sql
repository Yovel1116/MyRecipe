-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: recipe_recommender
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `ingredients` text NOT NULL,
  `instructions` text NOT NULL,
  `cuisine` varchar(100) DEFAULT NULL,
  `cooking_time` int DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Spaghetti Carbonara','Spaghetti, Guanciale, Eggs, Parmesan Cheese, Black Pepper','1. Cook spaghetti in boiling salted water. 2. Meanwhile, fry guanciale until crispy. 3. Beat eggs and mix with grated Parmesan cheese. 4. Combine cooked spaghetti with eggs and cheese mixture. 5. Add crispy guanciale and black pepper. Serve hot.','Italian',20,4.8),(2,'Chicken Tikka Masala','Chicken, Yogurt, Tomato Sauce, Cream, Spices','1. Marinate chicken in yogurt and spices. 2. Grill chicken until cooked. 3. Prepare tomato sauce with cream and spices. 4. Add grilled chicken to the sauce. 5. Simmer until flavors meld. Serve with rice or naan.','Indian',30,4.5),(3,'Caesar Salad','Romaine Lettuce, Croutons, Parmesan Cheese, Caesar Dressing','1. Toss chopped romaine lettuce with Caesar dressing. 2. Add croutons and grated Parmesan cheese. 3. Serve chilled.','American',10,4.3),(4,'Beef Stroganoff','Beef Sirloin, Onion, Mushroom, Sour Cream, Paprika','1. Sauté beef strips with onion and mushroom. 2. Add sour cream and paprika. 3. Simmer until sauce thickens. 4. Serve over cooked egg noodles.','Russian',40,4.6),(5,'Sushi Rolls','Sushi Rice, Nori, Fish, Vegetables','1. Prepare sushi rice and lay nori sheet on bamboo mat. 2. Spread rice evenly on nori. 3. Add fish and vegetables. 4. Roll tightly using bamboo mat. 5. Slice and serve with soy sauce and wasabi.','Japanese',45,4.9),(6,'Ratatouille','Eggplant, Zucchini, Bell Peppers, Tomatoes, Garlic','1. Sauté chopped vegetables with garlic in olive oil. 2. Layer vegetables in baking dish. 3. Bake until tender. 4. Serve as a side dish or over pasta.','French',35,4.2),(7,'Tandoori Chicken','Chicken, Yogurt, Spices, Lemon Juice','1. Marinate chicken in yogurt, spices, and lemon juice. 2. Grill or bake until cooked. 3. Serve hot with naan or rice.','Indian',25,4.7),(8,'Pasta Primavera','Pasta, Broccoli, Bell Peppers, Zucchini, Cherry Tomatoes','1. Cook pasta according to package instructions. 2. Sauté vegetables until tender. 3. Toss cooked pasta with vegetables. 4. Season with salt, pepper, and grated cheese. Serve hot.','Italian',25,4.4),(9,'Beef Bourguignon','Beef Chuck, Red Wine, Carrots, Onions, Mushrooms','1. Sear beef chunks until browned. 2. Sauté vegetables. 3. Deglaze pan with red wine. 4. Add beef, vegetables, and broth. 5. Simmer until beef is tender. Serve with crusty bread.','French',60,4.8),(10,'Vegetable Stir-Fry','Mixed Vegetables, Tofu, Soy Sauce, Ginger, Garlic','1. Stir-fry vegetables, tofu, ginger, and garlic in a hot pan. 2. Add soy sauce and stir until vegetables are tender. 3. Serve over steamed rice or noodles.','Chinese',20,4.6),(11,'Greek Salad','Cucumber, Tomato, Red Onion, Feta Cheese, Olives, Olive Oil','1. Chop vegetables and toss in a bowl. 2. Crumble feta cheese over the vegetables. 3. Drizzle with olive oil and season with salt and pepper. 4. Garnish with olives. Serve chilled.','Greek',15,4.3),(12,'Tiramisu','Ladyfingers, Mascarpone Cheese, Eggs, Coffee, Cocoa Powder','1. Dip ladyfingers in coffee and layer in a dish. 2. Mix mascarpone cheese with beaten eggs. 3. Spread mascarpone mixture over ladyfingers. 4. Repeat layers and refrigerate. 5. Dust with cocoa powder before serving.','Italian',20,4.7),(13,'Chicken Pad Thai','Rice Noodles, Chicken, Bean Sprouts, Peanuts, Tamarind Sauce','1. Cook rice noodles according to package instructions. 2. Stir-fry chicken until cooked. 3. Add noodles, bean sprouts, and tamarind sauce. 4. Toss until combined. 5. Garnish with crushed peanuts. Serve hot.','Thai',30,4.6),(14,'Margherita Pizza','Pizza Dough, Tomato Sauce, Mozzarella Cheese, Fresh Basil','1. Roll out pizza dough and spread tomato sauce. 2. Sprinkle grated mozzarella cheese over sauce. 3. Bake until crust is golden and cheese is melted. 4. Garnish with fresh basil leaves. Slice and serve hot.','Italian',20,4.5),(15,'Shrimp Scampi','Shrimp, Garlic, Butter, White Wine, Lemon Juice, Parsley','1. Sauté minced garlic in butter until fragrant. 2. Add shrimp and cook until pink. 3. Deglaze pan with white wine. 4. Add lemon juice and chopped parsley. 5. Serve over cooked pasta or with crusty bread.','Italian',25,4.8),(16,'Tom Yum Soup','Shrimp, Lemongrass, Kaffir Lime Leaves, Galangal, Chili, Lime Juice','Simmer ingredients in broth','Thai',30,4.7),(17,'Pho','Beef, Rice Noodles, Onion, Ginger, Star Anise, Fish Sauce','Simmer broth, cook noodles, assemble with beef and herbs','Vietnamese',60,4.9),(18,'Eggplant Parmesan','Eggplant, Marinara Sauce, Mozzarella Cheese, Parmesan Cheese, Basil','Bread and fry eggplant, layer with cheese and sauce, bake','Italian',40,4.5),(19,'Coq au Vin','Chicken, Red Wine, Mushrooms, Bacon, Onion, Garlic','Cook chicken in wine and vegetables','French',90,4.6),(20,'Pad See Ew','Rice Noodles, Chicken, Soy Sauce, Broccoli, Egg','Stir-fry noodles with chicken and vegetables','Thai',25,4.3),(21,'Ramen','Ramen Noodles, Pork, Soy Sauce, Miso, Green Onions, Egg','Cook noodles, assemble with broth and toppings','Japanese',45,4.8),(22,'Moussaka','Eggplant, Ground Beef, Tomato Sauce, Bechamel Sauce, Parmesan Cheese','Layer eggplant and beef, top with bechamel, bake','Greek',70,4.4),(23,'Shakshuka','Tomatoes, Eggs, Onion, Bell Pepper, Garlic, Cumin','Simmer tomatoes and vegetables, poach eggs in sauce','Middle Eastern',20,4.2),(24,'Chili Con Carne','Ground Beef, Kidney Beans, Tomato Sauce, Onion, Garlic, Chili Powder','Simmer beef and beans with spices','American',60,4.5),(25,'Croque Monsieur','Ham, Gruyere Cheese, Bechamel Sauce, Bread, Butter','Assemble sandwich, bake until golden','French',15,4.1),(26,'Bibimbap','Rice, Beef, Spinach, Carrots, Mushrooms, Egg, Gochujang','Cook ingredients separately, assemble with rice and sauce','Korean',35,4.7),(27,'Fried Rice','Rice, Egg, Peas, Carrots, Soy Sauce, Green Onions','Stir-fry rice with vegetables and soy sauce','Chinese',20,4.3),(28,'Pierogi','Potato, Cheese, Onion, Dough, Butter','Fill dough with potato mixture, boil, and fry','Polish',60,4.6),(29,'Beef Wellington','Beef Tenderloin, Puff Pastry, Mushrooms, Prosciutto, Dijon Mustard','Wrap beef in pastry, bake until golden','British',90,4.9),(30,'Lamb Tagine','Lamb, Apricots, Almonds, Onion, Garlic, Spices','Slow cook lamb with fruits and spices','Moroccan',120,4.7);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-08 16:25:56
