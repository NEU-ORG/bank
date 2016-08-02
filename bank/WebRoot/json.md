http://localhost:8080/bank/getUserAccounts?userName=lzn
//搜索数据库中userName下所有的account
格式：有数据
{"result":
	[{	"isSigned":"none",
		"accountNumber":"123456789",
		"type":"活期",
		"availableBalance":1000.0,
		"bank":{"companies":[],"name":"东北大学支行","id":1,"type":"中国建设银行","companyAccounts":[]},
		"transactionPassword":"123456",
		"balance":1000.0,
		"name":"lzn的卡",
		"withdrawalPassword":"123456",
		"currency":"CNY",
		"id":1,
		"createDate":{"date":31,"hours":15,"seconds":17,"month":6,"nanos":0,"timezoneOffset":-480,"year":116,"minutes":14,"time":1469949257000,"day":0},
		"status":"normal"}
	],
"status":true}
无数据：{"result":null,"status":false}

http://localhost:8080/bank/getUserList

http://localhost:8080/bank/AccountJsonAction

http://localhost:8080/bank/QueryAddress
//搜索所有地址
格式：
{"result":
	[{	"address":{},
		"codeName":"中国",
		"id":1,
		"type":"country",
		"codeValue":"CN"
	},{	"address":{"address":{},"codeName":"中国","id":1,"type":"country","codeValue":"CN"},
		"codeName":"辽宁",
		"id":2,
		"type":"province",
		"codeValue":"LN"
	},{	"address":{"address":{"address":{},"codeName":"中国","id":1,"type":"country","codeValue":"CN"},"codeName":"辽宁","id":2,"type":"province","codeValue":"LN"},
		"codeName":"沈阳",
		"id":3,
		"type":"city",
		"codeValue":"SY"
	},{	"address":{"address":{"address":{},"codeName":"中国","id":1,"type":"country","codeValue":"CN"},"codeName":"辽宁","id":2,"type":"province","codeValue":"LN"},
		"codeName":"大连",
		"id":4,
		"type":"city",
		"codeValue":"DL"}
	],
"status":true}