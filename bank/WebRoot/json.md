http://localhost:8080/bank/getUserAccounts?userName=lzn
//�������ݿ���userName�����е�account
��ʽ��������
{"result":
	[{	"isSigned":"none",
		"accountNumber":"123456789",
		"type":"����",
		"availableBalance":1000.0,
		"bank":{"companies":[],"name":"������ѧ֧��","id":1,"type":"�й���������","companyAccounts":[]},
		"transactionPassword":"123456",
		"balance":1000.0,
		"name":"lzn�Ŀ�",
		"withdrawalPassword":"123456",
		"currency":"CNY",
		"id":1,
		"createDate":{"date":31,"hours":15,"seconds":17,"month":6,"nanos":0,"timezoneOffset":-480,"year":116,"minutes":14,"time":1469949257000,"day":0},
		"status":"normal"}
	],
"status":true}
�����ݣ�{"result":null,"status":false}

http://localhost:8080/bank/getUserList

http://localhost:8080/bank/AccountJsonAction

http://localhost:8080/bank/QueryAddress
//�������е�ַ
��ʽ��
{"result":
	[{	"address":{},
		"codeName":"�й�",
		"id":1,
		"type":"country",
		"codeValue":"CN"
	},{	"address":{"address":{},"codeName":"�й�","id":1,"type":"country","codeValue":"CN"},
		"codeName":"����",
		"id":2,
		"type":"province",
		"codeValue":"LN"
	},{	"address":{"address":{"address":{},"codeName":"�й�","id":1,"type":"country","codeValue":"CN"},"codeName":"����","id":2,"type":"province","codeValue":"LN"},
		"codeName":"����",
		"id":3,
		"type":"city",
		"codeValue":"SY"
	},{	"address":{"address":{"address":{},"codeName":"�й�","id":1,"type":"country","codeValue":"CN"},"codeName":"����","id":2,"type":"province","codeValue":"LN"},
		"codeName":"����",
		"id":4,
		"type":"city",
		"codeValue":"DL"}
	],
"status":true}