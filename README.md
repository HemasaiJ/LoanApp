Basic Loan Application

1. Add new Loan
**Method Type**  - POST
**API base URL** - /loan
**Request Body** - 
`{
"name" : "Hemasai",
"application" : {
    "name" : "Gpay",
    "amount" : 5000
  }
}`
**Response** - 
`{
"status": "success",
"message": "Successfully Added"
}`

2. Get All Loans
**Method Type**  - GET
**API base URL** - /loans
**Response** -
`{
"status" : "success",
"data":{
"Hemasai" : [
{
"name": "Phonepe",
"amount": 5000,
"status": "open"
}
]
}
}`

3. Cancel a loan
**Method Type**  - POST
**API base URL** - /loan/cancel
**Request Body** - 
`{
"name" : "Hemasai",
"application" : {
    "name" : "Gpay",
    "amount" : 5000
  }
}`
**Response** - 
`{
"status": "success",
"message": "Successfully Cancelled Loan"
}`


