import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
from firebase import firebase

firebase = firebase.FirebaseApplication('https://hackfest1-8fd03.firebaseio.com/',None)


cred = credentials.Certificate('C:\Users\Umang\Desktops\hackfest1-8fd03-firebase-adminsdk-ssmof-616cfc7844.json')


firebase_admin.initialize_app(cred, {
    'databaseURL':'https://hackfest1-8fd03.firebaseio.com/',
    'databaseAuthVariableOverride': None
})


ref = db.reference()
#print(type(ref.get()))
snapshot = ref.get()
for key, val in snapshot.items():
	snapshot2=ref.child(key).child('price').get()
	print(type(snapshot2))
    
