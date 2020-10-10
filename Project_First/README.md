Rest project

Before run app you should connect to DB PostgresQL, all settings check in applications.properties

After, in your REST-client you should auth with admin or user role

You can:

1)/user/add - create new user
2)/user/delete/{id} - delete user by id
3)/user/getAll/{age} - get all users with same age({age})
4)/admin/getAll - get all users
5)/user/update/{id} - update info for user with id({id})
6)/user/get/{id} - get user by id
7)/user/getMaxAge -get user with max age
