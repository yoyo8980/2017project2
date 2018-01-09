<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<style>
        *{
            overflow: hidden;
          
        }
        #wrapper{
            position: absolute;
            width: 100%;
            margin: 0 auto;
            height: 800px;
            transition: 1s;
        }
        
        #logo{
            position: relative;
            float: right;
            margin-right: 50px;
        }
        #logo:hover{
            width: 200px;
            height: 60px;
            
        }
        #padding>h1{
           color: #3D1775;
            align-items: center;
            width: 160px;
            display: inline-block;
            
            font-size: 2em;
            position: absolute;
            left: 0px;
            transition: 0.5s;
            cursor: pointer;
            text-align: center;
            /* cf. transition: width 0.5s makes it rugh */ 
        }
        #content{
            margin-top: 140px;
            
        }
        #content>div{
            display: none;
            text-align: center;
            margin-top: 20px;
        }

	#padding{
        position: relative;
        padding-top: 360px;
		width: 100%;
		height: 1000px;
		z-index: 1;
		transition: 1s;
	}
         
	#imgs{
        position: relative;
        visibility:hidden;
        padding-top: 600px;
        padding-left: 250px;
        width: 1100px;
        height: 600px;
        z-index:-1 ;
        transition: 0.5s;
	}
       
        #video{
            position: absolute;
            visibility: hidden;
            padding-top: 600px;
            width: 1100px;
            height: 600px;
            z-index:-1 ;
            transition: 0.5s;
        }
        #map{
            position: absolute;
            visibility: hidden;
            width: 1100px;
	        height: 600px;
        }
        #login{
            position: absolute;
            margin-left: 2000px;
            margin-top: 300px;
            visibility: hidden;
            transition: 1s;
        }
	 </style>
    <script>
         
        
        window.onload = function(){
            var menucnt=0; 
            function playVid() { 
                            vid.play(); 
                        };
            function pauseVid() { 
                            vid.pause(); 
                        } 
            
            var vid = document.getElementById("video");
            var menu = document.querySelectorAll("#padding>h1");
            var contentPrev = document.querySelectorAll("#content > div:nth-child(odd)");
            var contentFull = document.querySelectorAll("#content > div:nth-child(even)");
            //var screenW = window.screen.width;
            var screenW = window.innerWidth;
            
            var wd=screenW/menu.length+100;  
            var list=new Set();
            for(var j=0; j<menu.length; j++){
                var t=wd*[j];
                list.add(t); 
            }
            var lcarr=Array.from(list);
            for(var k=0; k<menu.length; k++){
               menu[k].style.left=lcarr[k]+"px";
                               
                //console.log(lcarr[k]);  
            }
        var tStamp=0;
        var cnt=0;
        document.addEventListener("wheel", function(e){
            
            console.log(lcarr);
           function actWheel(){ 
            if(cnt>menu.length-1){cnt=0;}
            for(var i=0; i<menu.length; i++){
                
                    if((cnt+i)>=menu.length){menu[i].style.left= lcarr[(cnt+i-menu.length)]+"px";
                console.log("cnt"+cnt);
                    }else{menu[i].style.left= lcarr[(cnt+i)]+"px";}
                }
            cnt++;
           };
            console.log(e);
             var eStamp=e.timeStamp;
            tStamp+=70; //이쪽 마우스 휠 관련 속도 조정할떄 값 변경
            if(tStamp<eStamp){
                tStamp=eStamp; 
                window.setTimeout(actWheel, 70); // 이쪽 마우스 휠 관련 속도 조정할떄 값 변경
            }else{tStamp=eStamp+300;} // 이쪽 마우스 휠 관련 속도 조정할떄 값 변경
            
            
        });
            
             document.getElementById("logo").addEventListener("click",function(){
                 document.getElementById("wrapper").style.width="70%";
                 document.getElementById("wrapper").style.float="left";
                 document.getElementById("padding").style.marginLeft="0px";
                 document.getElementById("content").style.marginTop="200px";
                 document.getElementById("imgs").style.paddingLeft="50px";
                 document.getElementById("login").style.visibility="visible";
                 document.getElementById("login").style.width="30%";
                 document.getElementById("login").style.marginLeft= "1300px";
                 document.getElementById("login").style.float="right";
                 });
             
            //mouseoever - enlarge menu and show preview
            for(let i=0; i<menu.length; i++){
               
                menu[i].addEventListener("mouseover", function(){
                    document.getElementById("map").style.visibility="hidden";
                    menu[i].style.fontSize="3em";
                    menu[i].style.color="#B496DF";
                    menu[i].style.width="250px";
                    document.getElementById("imgs").style.paddingTop="150px";
                    document.getElementById("imgs").style.paddingLeft="250px";
                    document.getElementById("video").style.padding="0px";
                    if(i!=1){
                        document.getElementById("imgs").style.visibility="visible";
                        
                    }else{
                        document.getElementById("video").style.visibility="visible";
                        playVid();
                    }
                    
                    //remove all preview
                    for(let j=0; j<contentPrev.length; j++){
                    	contentPrev[j].style.display="none";
                    }
                    //show the hoovered preview
                        contentPrev[i].style.display="block";
                        contentPrev[i].style.opacity="0.5";
                        contentPrev[i].style.position="absolute";
                        contentPrev[i].style.left="400px";
                        contentPrev[i].style.top="100px";
                        contentPrev[i].style.zIndex="10";
                    
                    menu[i].addEventListener("mouseout", function(){
                    	
                    	contentPrev[i].style.display="none";
                    	
                        document.getElementById("imgs").style.visibility="hidden";
                        document.getElementById("video").style.visibility="hidden";
                        document.getElementById("imgs").style.paddingTop="0px";
                        document.getElementById("video").style.paddingTop="0px";
                        if(menucnt>=1){
                             for(let i=0; i<menu.length; i++){
                            menu[i].style.fontSize="1.5em";
                             }
                        }else{
                        menu[i].style.fontSize="2em";
                        }
                        menu[i].style.color="#3D1775";
                        menu[i].style.width="160px" ;
                        document.body.style.backgroundColor="white";
                    
                        document.getElementById("map").style.visibility="hidden";
                    });
                });
            }
            
            //mouseclick to effect on menu
            //and to show its content in main
            for(let i=0; i<menu.length; i++){
               
                menu[i].addEventListener("click", function(){
                     menucnt++;
                    menu[i].style.transform="rotate(7deg)" ;
                    for(let j=0; j<menu.length; j++){
                        menu[j].style.backgroundColor="white";
                    }
                    menu[i].style.backgroundColor="green";
                    
                    document.getElementById("padding").style.padding="20px";
                    document.getElementById("imgs").style.display="none";
                    document.getElementById("map").style.display="none";
                    document.getElementById("video").style.display="none";
                   
                    
                    //remove click effect
                    window.setInterval(function(){ 
                        menu[i].style.transform="none"
                    }, 1000);
                    
                    //hide all the other contents
                    for(let j=0; j<contentFull.length; j++){
                    	contentPrev[j].style.display="none";
                    	contentFull[j].style.display="none";
                    }
                    
                    //show the clicked content
                        contentFull[i].style.display="block";
                        contentFull[i].style.position="absolute";
                        contentFull[i].style.left="0px";
                        contentFull[i].style.top="200px";
                        contentFull[i].style.zIndex="10";
                    
                });   
            }
        };
    </script>
</head>
<body>
 <div id="wrapper">
    <img id="logo" src="imgs/header02.png"><!--LMS시스템 들어가야함.-->
    <div id="padding">
    	<c:forEach items="${loadmenu }" var="menulist">
	    	<h1>${menulist }</h1>
	    </c:forEach>
    </div>
    <video id="video" width="320" height="176" loop="5">
    <source src="imgs/2.mp4" type="video/mp4">
    </video>
    <img id = "imgs" src="imgs/1.jpg" >
    <img id = "map" src="imgs/map01.png" >
    <div id="content">
    	<c:forEach items="${loadmenu }" var="menulist">
    		<div id="preview"><img src="upload/${menulist }/preview.png"/></div>
	    	<div id="fullview"><c:import url="upload/${menulist }/fullview.html"  charEncoding="utf-8"></c:import></div>
	    </c:forEach>
    </div>
</div>
    <div id="login">
    <p>직원전용</p>
    <form action="lmsindex.do" method="post">
    <div>
        <label for="webid">ID</label>
        <input type="text" name="webid" required/>
    </div>
    <div>
        <label for="webpw">PW</label>
        <input type="text" name="webpw" required/>
    </div>
    <div>
        <button type="submit">로그인</button>
    </div>
</form>
        
    </div>
</body>
</html>