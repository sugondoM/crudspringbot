# crudspringbot

Dear Tester, Some prerequisite are need to meet before you test the program.
You need to build or you can run it via your IDE (for instance intellij)

You need some rest client to test it
For Issue No. 1
- You can use a rest client
- Try to call: http://localhost:8080/triangle?count=6
- METHOD is GET
- See it on raw

For Issue No.2
- You need to deploy the database first
- I put the source sql on src/main/resource/dbinit.sql

+ Testing Select
- Try to call: http://localhost:8080/listPerson
- METHOD is POST
- no PARAM

+ Testing Add
- Try to call: http://localhost:8080/addPerson
- METHOD is POST
- BODY CONTENT TYPE is application/json
- PARAM e.g:
{
  "id":null,
  "name":"test",
  "phone":"0819281921"
}

+ Testing Edit
- Try to call: http://localhost:8080/editPerson
- METHOD is POST
- BODY CONTENT TYPE is application/json
- PARAM e.g:
{
  "id":1,
  "name":"test",
  "phone":"0819281921"
}

+ Testing Delete
- Try to call: http://localhost:8080/deletePerson
- METHOD is POST
- BODY CONTENT TYPE is application/json
- PARAM e.g:
{
"id":2
}
