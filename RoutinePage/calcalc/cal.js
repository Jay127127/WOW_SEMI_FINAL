let armName = ["밥","고기","옥수수","빵"];
let index = 0;
setInterval(function(){
    console.log(foodName[index++]);
    if(index==foodName.length){
        close();
    }
        

},5000);
