# api documentation

## Authentication

### login 

`POST` /user/login
```
data
{
email:
password:
}
```
response `200`
```
{
	userid
	email
	name
	token
} 
```
response `400`
```
{
error: true,
 message:
}
```

### logout
`POST` /user/logout
```
header
{
Auth: <token>
}
```
response `200`
```
{} 
```
response `400`
```
{
error: true,
 message:
}
```

## todo apis
### get   all todo

`GET` /todo
returns list of todos of that user;
```
header
{
Auth: <token>
}

```
response `200`
```
[{
	id:<int>,
	todo:<string>,
	status:<boolean>
}] 
```
response `400`
```
{
error: true,
 message:
}
```

if no or incorrect auth token
response `403`

### todo by ID
`GET` /todos/<id>

```
header
{
Auth: <token>
}

```
response `200`
```
[{
	id:<int>,
	todo:<string>,
	status:<boolean>
}] 
```
response `400`
```
{
error: true,
 message:
}
```

if no or incorrect auth token
response `403`

### create todo
`POST` /todos

```
header
{
Auth: <token>
}
data {
todo:<string>
}
```
response `200`
```
{
	id:<int>,
	todo:<string>,
	status:false
} 
```
response `400`
```
{
error: true,
 message:
}
```

if no or incorrect auth token
response `403`

