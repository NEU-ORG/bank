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

http://localhost:8080/bank/getTransactionDetail?accountId=1

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

http://localhost:8080/bank/QueryConstant
//��ȡ������
{"result":
[{"id":1,"text":"����","type":"�������","value":0.003},
{"id":2,"text":"����һ��","type":"�������","value":0.0175},
{"id":3,"text":"���ڶ���","type":"�������","value":0.0225},
{"id":4,"text":"��������","type":"�������","value":0.0275},
{"id":5,"text":"��������","type":"�������","value":0.0275},
{"id":6,"text":"����ת��","type":"������","value":0.01},
{"id":7,"text":"����һ��","type":"��������","value":0.0435},
{"id":8,"text":"���ת��ʱ��","type":"ʱ��","value":10.0},
{"id":9,"text":"�������","type":"��������","value":0.0535}],
"status":true}