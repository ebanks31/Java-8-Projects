print('Hello World!');
var MyJavaClass = Java.type('com.ebanks.java.Nashorn');

var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
};

var add = function(x, y) {  
    return x + y;
}

var subtract = function(x, y) {  
    return x - y;
}

var multiply = function(x, y) {   
    return x * y;
}

var divide = function(x, y) {   
    return x / y;
}


var javaClassFun = function()
{

var result = MyJavaClass.fun1('John Doe');
print(result);


MyJavaClass.fun2(123);
//class java.lang.Integer

MyJavaClass.fun2(49.99);
//class java.lang.Double

MyJavaClass.fun2(true);
//class java.lang.Boolean

MyJavaClass.fun2("hi there")
//class java.lang.String

MyJavaClass.fun2(new Number(23));
//class jdk.nashorn.internal.objects.NativeNumber

MyJavaClass.fun2(new Date());
//class jdk.nashorn.internal.objects.NativeDate

MyJavaClass.fun2(new RegExp());
//class jdk.nashorn.internal.objects.NativeRegExp

MyJavaClass.fun2({foo: 'bar'});
//class jdk.nashorn.internal.scripts.JO4

return result;
}

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}
    
    var printPerson = function()
    {
    var person1 = new Person("Test", "Name");
    var result = MyJavaClass.fun4(person1);
    return result;
    }
    
    var printAllArrayListItems = function()
    {
    	var ArrayList = Java.type('java.util.ArrayList');
    	var list = new ArrayList();
    	list.add('a');
    	list.add('b');
    	list.add('c');

    	for each (var el in list) print(el);  // a, b, c
    	
    }
    
    var printAllHashMapItems = function()
    {
    var map = new java.util.HashMap();
    map.put('foo', 'val1');
    map.put('bar', 'val2');
    map.put('bar1', 'val3');
    map.put('bar2', 'val4');
    for each (var e in map.keySet()) print(e);  // foo, bar

    for each (var e in map.values()) print(e);  // val1, val2
    }
    
    
    var lambda = function()
    {
    	var list2 = new java.util.ArrayList();
    	list2.add("ddd2");
    	list2.add("aaa2");
    	list2.add("bbb1");
    	list2.add("aaa1");
    	list2.add("bbb3");
    	list2.add("ccc");
    	list2.add("bbb2");
    	list2.add("ddd1");

    	list2
    	    .stream()
    	    .filter(function(el) {
    	        return el.startsWith("aaa");
    	    })
    	    .sorted()
    	    .forEach(function(el) {
    	        print(el);
    	    });
    	    // aaa1, aaa2
    }
    
    var extendedClass = function()
    {
    	var Runnable = Java.type('java.lang.Runnable');
    	var Printer = Java.extend(Runnable, {
    	    run: function() {
    	        print('printed from a separate thread');
    	    }
    	});

    	var Thread = Java.type('java.lang.Thread');
    	new Thread(new Printer()).start();

    	new Thread(function() {
    	    print('printed from another thread');
    	}).start();

    	// printed from a separate thread
    	// printed from another thread
    }
