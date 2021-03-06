# mocaccino-community-pub

## examples of use

### employee entity:
```
$ curl -v -i http://localhost:8090/rest/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/employees HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:42:43 GMT
Date: Wed, 11 Nov 2020 19:42:43 GMT

< 
{
  "_embedded" : {
    "employees" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/employees"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/employees"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/employees/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/profile/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/profile/employees HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/alps+json
Content-Type: application/alps+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:44:28 GMT
Date: Wed, 11 Nov 2020 19:44:28 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "employee-representation",
      "href" : "http://localhost:8090/rest/profile/employees",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      }, {
        "name" : "surname",
        "type" : "SEMANTIC"
      }, {
        "name" : "email",
        "type" : "SEMANTIC"
      }, {
        "name" : "profession",
        "type" : "SEMANTIC"
      }, {
        "name" : "username",
        "type" : "SEMANTIC"
      } ]
    }, {
      "id" : "get-employees",
      "name" : "employees",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "page",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The page to return."
        }
      }, {
        "name" : "size",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The size of the page to return."
        }
      }, {
        "name" : "sort",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The sorting criteria to use to calculate the content of the page."
        }
      } ],
      "rt" : "#employee-representation"
    }, {
      "id" : "create-employees",
      "name" : "employees",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "delete-employee",
      "name" : "employee",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "update-employee",
      "name" : "employee",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "get-employee",
      "name" : "employee",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "patch-employee",
      "name" : "employee",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "name" : "likeByEmail",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "email",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "likeBySurname",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "surname",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "likeByName",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "likeByUsername",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "username",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/employees/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/employees/search HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:45:19 GMT
Date: Wed, 11 Nov 2020 19:45:19 GMT

< 
{
  "_links" : {
    "likeByEmail" : {
      "href" : "http://localhost:8090/rest/employees/search/likeByEmail{?email}",
      "templated" : true
    },
    "likeBySurname" : {
      "href" : "http://localhost:8090/rest/employees/search/likeBySurname{?surname}",
      "templated" : true
    },
    "likeByName" : {
      "href" : "http://localhost:8090/rest/employees/search/likeByName{?name}",
      "templated" : true
    },
    "likeByUsername" : {
      "href" : "http://localhost:8090/rest/employees/search/likeByUsername{?username}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8090/rest/employees/search"
    }
  }
* Connection #0 to host localhost left intact
}
```

### company entity:
```
$ curl -v -i http://localhost:8090/rest/companies
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/companies HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:47:08 GMT
Date: Wed, 11 Nov 2020 19:47:08 GMT

< 
{
  "_embedded" : {
    "companies" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/companies"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/companies"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/companies/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/profile/companies
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/profile/companies HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/alps+json
Content-Type: application/alps+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:47:39 GMT
Date: Wed, 11 Nov 2020 19:47:39 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "company-representation",
      "href" : "http://localhost:8090/rest/profile/companies",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      }, {
        "name" : "contests",
        "type" : "SAFE",
        "rt" : "http://localhost:8090/rest/profile/contests#contest-representation"
      }, {
        "name" : "employee",
        "type" : "SAFE",
        "rt" : "http://localhost:8090/rest/profile/employees#employee-representation"
      } ]
    }, {
      "id" : "get-companies",
      "name" : "companies",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "page",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The page to return."
        }
      }, {
        "name" : "size",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The size of the page to return."
        }
      }, {
        "name" : "sort",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The sorting criteria to use to calculate the content of the page."
        }
      } ],
      "rt" : "#company-representation"
    }, {
      "id" : "create-companies",
      "name" : "companies",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#company-representation"
    }, {
      "id" : "delete-company",
      "name" : "company",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#company-representation"
    }, {
      "id" : "update-company",
      "name" : "company",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#company-representation"
    }, {
      "id" : "get-company",
      "name" : "company",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#company-representation"
    }, {
      "id" : "patch-company",
      "name" : "company",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#company-representation"
    }, {
      "name" : "likeByName",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/companies/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/companies/search HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:48:23 GMT
Date: Wed, 11 Nov 2020 19:48:23 GMT

< 
{
  "_links" : {
    "likeByName" : {
      "href" : "http://localhost:8090/rest/companies/search/likeByName{?name}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8090/rest/companies/search"
    }
  }
* Connection #0 to host localhost left intact
}
```

### contest entity:
```
$ curl -v -i http://localhost:8090/rest/contests
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/contests HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:49:12 GMT
Date: Wed, 11 Nov 2020 19:49:12 GMT

< 
{
  "_embedded" : {
    "contests" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/contests"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/contests"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/contests/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/profile/contests
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/profile/contests HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/alps+json
Content-Type: application/alps+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:49:44 GMT
Date: Wed, 11 Nov 2020 19:49:44 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "contest-representation",
      "href" : "http://localhost:8090/rest/profile/contests",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      }, {
        "name" : "title",
        "type" : "SEMANTIC"
      }, {
        "name" : "description",
        "type" : "SEMANTIC"
      }, {
        "name" : "date",
        "type" : "SEMANTIC"
      }, {
        "name" : "participants",
        "type" : "SAFE",
        "rt" : "http://localhost:8090/rest/profile/employees#employee-representation"
      } ]
    }, {
      "id" : "get-contests",
      "name" : "contests",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "page",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The page to return."
        }
      }, {
        "name" : "size",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The size of the page to return."
        }
      }, {
        "name" : "sort",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The sorting criteria to use to calculate the content of the page."
        }
      } ],
      "rt" : "#contest-representation"
    }, {
      "id" : "create-contests",
      "name" : "contests",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#contest-representation"
    }, {
      "id" : "delete-contest",
      "name" : "contest",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#contest-representation"
    }, {
      "id" : "update-contest",
      "name" : "contest",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#contest-representation"
    }, {
      "id" : "get-contest",
      "name" : "contest",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#contest-representation"
    }, {
      "id" : "patch-contest",
      "name" : "contest",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#contest-representation"
    }, {
      "name" : "likeByName",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "likeByTitle",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "title",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host localhost left intact
}
$ curl -v -i http://localhost:8090/rest/contests/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/contests/search HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 11 Nov 2020 19:50:27 GMT
Date: Wed, 11 Nov 2020 19:50:27 GMT

< 
{
  "_links" : {
    "likeByName" : {
      "href" : "http://localhost:8090/rest/contests/search/likeByName{?name}",
      "templated" : true
    },
    "likeByTitle" : {
      "href" : "http://localhost:8090/rest/contests/search/likeByTitle{?title}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8090/rest/contests/search"
    }
  }
* Connection #0 to host localhost left intact
}
```

## Cross-Origin Resource Sharing test with curl
```
$ curl -H "Origin: http://localhost:8010" -H "Access-Control-Request-Method: GET" -H "Access-Control-Request-Headers: X-Requested-With" -X GET --verbose http://localhost:8090/rest/employees
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8090 (#0)
> GET /rest/employees HTTP/1.1
> Host: localhost:8090
> User-Agent: curl/7.58.0
> Accept: */*
> Origin: http://localhost:8010
> Access-Control-Request-Method: GET
> Access-Control-Request-Headers: X-Requested-With
> 
< HTTP/1.1 200 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Sun, 29 Nov 2020 17:25:29 GMT
< 
{
  "_embedded" : {
    "employees" : [ {
      "name" : "John",
      "surname" : "Doe",
      "email" : "john.doe@example.local",
      "profession" : "developer",
      "username" : "johndoe",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8090/rest/employees/4"
        },
        "employee" : {
          "href" : "http://localhost:8090/rest/employees/4"
        }
      }
    }, {
      "name" : "Zoe",
      "surname" : "Write",
      "email" : "zoe.write@example.local",
      "profession" : "designer",
      "username" : "zoewrite",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8090/rest/employees/5"
        },
        "employee" : {
          "href" : "http://localhost:8090/rest/employees/5"
        }
      }
    }, {
      "name" : "Liz",
      "surname" : "Gone",
      "email" : "liz.gone@example.local",
      "profession" : "manager",
      "username" : "lizgone",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8090/rest/employees/6"
        },
        "employee" : {
          "href" : "http://localhost:8090/rest/employees/6"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8090/rest/employees"
    },
    "profile" : {
      "href" : "http://localhost:8090/rest/profile/employees"
    },
    "search" : {
      "href" : "http://localhost:8090/rest/employees/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```

## example of adding an item contest:
```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"fourth_contest","title":"some title","description":"some description","date":"2020-12-20"}' http://127.0.0.1:8090/rest/contests
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> POST /rest/contests HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 99
> 
* upload completely sent off: 99 out of 99 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8090/rest/contests/55
Location: http://127.0.0.1:8090/rest/contests/55
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 20 Dec 2020 16:21:56 GMT
Date: Sun, 20 Dec 2020 16:21:56 GMT

< 
{
  "name" : "fourth_contest",
  "title" : "some title",
  "description" : "some description",
  "date" : "2020-12-19T23:00:00.000+00:00",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8090/rest/contests/55"
    },
    "contest" : {
      "href" : "http://127.0.0.1:8090/rest/contests/55"
    },
    "participants" : {
      "href" : "http://127.0.0.1:8090/rest/contests/55/participants"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
