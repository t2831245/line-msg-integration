### line-msg-integration

#### Setting
* set environment variables:
lineKey=xxxxxx;lineSecret=oooooo
* tool bar -> run -> edit configurations -> environment variables

#### Implement functions
* receive message from line webhook, save the user info and message in MongoDB
* send message back to line
* query message list of the user from MongoDB

#### Api
```
post 
http://localhost:8080/msg
{
    "userId": "lineUserId",
    "text": "test pushing"
}

get
http://localhost:8080/msg?userId=lineUserId
```

MongoDB line official dev account QRCode path
```./qrcode.png```
