# 🛒 Cart Service (Ecommerce Microservices)

The **Cart Service** manages **user shopping cart operations** in the Ecommerce Microservices system.

It communicates with the **Product Service** using a **Feign Client** to fetch product details and maintains user‑specific cart data.

---

#  Tech Stack

* **Spring Boot**
* **Spring Cloud OpenFeign**
* **REST APIs**
* **Microservices Architecture**
* **API Gateway Integration**
* **MySQL (Persistence)**
* **Maven**
* **Lombok**

---

#  Features Implemented

### **Add Product to Cart**

* Fetches product details from Product Service
* Adds or updates product quantity in user cart

###  **View Cart**

* Retrieves all cart items for a specific user

### **Remove Item from Cart**

* Deletes a specific product from the cart

###  **Clear Cart**

* Deletes all cart items after successful checkout

---

#  API Endpoints

All endpoints are exposed through the **API Gateway** under the `/Cart` path.

---

##  Add Product to Cart

**GET** `/Cart/getById/{id}`

Fetches product details from Product Service and inserts it into the user cart.

###  Path Variable

```
id = productId
```

###  Header

```
X-UserId: 101
```

###  Response

```json
{
  "productId": 1,
  "productName": "iPhone 15",
  "price": 79999,
  "quantity": 1
}
```

---

##  Get Cart Items

**GET** `/Cart/getCart`

Returns all cart items for the authenticated user.

###  Header

```
X-UserId: 101
```

###  Response

```json
[
  {
    "productId": 1,
    "productName": "iPhone 15",
    "price": 79999,
    "quantity": 1
  }
]
```

---

##  Remove Item from Cart

**DELETE** `/Cart/delete`

Deletes a specific cart item for the user.

###  Query Parameters

```
cartId = 55
```

###  Header

```
X-UserId: 101
```

###  Response

```text
Product Successfully deleted from cart
```

---

##  Clear Cart

**DELETE** `/Cart/All/deleteAllByUserId`

Deletes all cart items for the user (usually after checkout).

###  Header

```
X-UserId: 101
```

###  Response

```text
Thanks for buying the products
```

---

#  Service Communication

###  Feign Client (Product Service)

* Fetches product details by product ID
* Ensures cart always has up‑to‑date product data
* No event‑driven communication (Kafka not used)

---

#  Cart Processing Flow

```
Frontend
   ↓
API Gateway
   ↓
Cart Service
   ↓ (Feign)
Product Service
```

---

#  Future Enhancements (To Be Implemented)

###  Update Product Quantity

Allow users to increase or decrease item quantity.

###  Cart Persistence Across Sessions

Retain cart even after logout.

###  Cart Expiry

Auto‑clear inactive carts.

###  Price Revalidation Before Checkout

Ensure latest prices before order creation.

---

##  Author

**Pranav Sharma**
Spring Boot | Feign Client | Microservices | Backend Engineering

---
