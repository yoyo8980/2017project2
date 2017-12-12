<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프</title>
<link rel="stylesheet" href="css/index.css"></link>
<meta name="viewport" content="user-scalable=no,initial-scale=1" />
<script>
         window.addEventListener("load" ,function(){
        	var lmsin;
        	var menuover;
        	var menuout;
        	var menuclick;
            var menucnt=0; 
           	
            var menuccnt=0; 
            var wheelcnt=0;
            var menubrcnt=0;
            var menubrcnt2=0;
            var precnt=0;
           
            function reload(){ //새로고침
            	location.reload();
            }
            
            var menutop= 360;
            var mmenutop=100;
            var vid = document.getElementById("video");
            var menu = document.querySelectorAll("#padding>h1");
            var content = document.querySelectorAll("#content > div");
            //var screenW = window.screen.width;
            var screenW = window.innerWidth;
            var contentPrev = document.querySelectorAll("#content > div:nth-child(odd)");
            var contentFull = document.querySelectorAll("#content > div:nth-child(even)");
            var wd=screenW/menu.length+200; //메뉴위치 절대값
            
        // 메뉴위치
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
         // 마우스휠 -김성식
        var tStamp=0;
            var cnt=0;
           function actWheel(){ 
            if(cnt>menu.length-1){cnt=0;}
            for(var i=0; i<menu.length; i++){
                
                    if((cnt+i)>=menu.length){menu[i].style.left= lcarr[(cnt+i-menu.length)]+"px";
                //console.log("cnt"+cnt);
                    }else{menu[i].style.left= lcarr[(cnt+i)]+"px";}
                }
            cnt++;
	            /* console.log(e); */
	            var eStamp=e.timeStamp;
	            tStamp+=70; //이쪽 마우스 휠 관련 속도 조정할떄 값 변경
	            if(tStamp<eStamp){
	                tStamp=eStamp; 
	                window.setTimeout(actWheel,70); // 이쪽 마우스 휠 관련 속도 조정할떄 값 변경   
	          
	            }else{tStamp=eStamp+300;}
            
           };
           
         //휠 이벤트리스너  
         
        document.addEventListener("wheel", actWheel);
         
        
        	 document.getElementById("logo").addEventListener("click",function(){ //lms시스템 오픈.
        		 menubrcnt++;
        	
        		 document.getElementById("wrapper").style.transition="0.5s";
        		 document.getElementById("wrapper").style.position="absolute";
        		 document.getElementById("wrapper").style.width="70%";
                 document.getElementById("wrapper").style.float="left";
                 document.getElementById("padding").style.marginLeft="0px";
                 document.getElementById("padding").style.width="100%";
                 document.getElementById("content").style.marginTop="200px" ;
                 document.getElementById("login").style.visibility="visible";
                 document.getElementById("login").style.position= "relative";
                 document.getElementById("login").style.height="900px";
                 document.getElementById("login").style.width="30%";
                 document.getElementById("login").style.float="right";
                 document.getElementById("login").style.overlow="visible" ;
                 
                 var qwe=0; //메뉴바 두줄 만들기
                 if(menubrcnt2==0){
                	 var list=new Set();
                     for(var j=0; j<menu.length; j++){
                         var t=wd*[j];
                         list.add(t); 
                         
                     }
                     var lcarr=Array.from(list);
                     for(var k=0; k<menu.length; k++){
                        menu[k].style.left=lcarr[k]+"px";
                                        
                         //console.log(lcarr[k]) ;  
                     }
                     
                     }else{ //다시 복구
                     	 wd2=screenW/menu.length+120;
                          var list2=new Set();
                          for(var j=0; j<menu.length; j++){
                              var t=wd2*[j];
                              list2.add(t); 
                              
                          }
                          var lcarr2=Array.from(list2);
                          for(let j=0; j<menu.length; j++){
                         	 if(j>3){ //j[3] 이상일경우 아래로 내리기 2번째줄
                         		 menu[j].style.backgroundColor="transparent"; // 배경투명.
                           		menu[j].style.left=lcarr2[qwe]+"px";//메뉴위치
                           		menu[j].style.top="50px";
                           		qwe++;
                         	 }else{
                         		 //j[3] 아래일경우 1번째줄
                              menu[j].style.backgroundColor="transparent" ;
                      		menu[j].style.left=lcarr2[j]+"px";//메뉴위치
                         	 }
                     }     
                     }
                 document.getElementById("logo").addEventListener("click",function(){// lms끌때
                	 menubrcnt=0;
                	 document.getElementById("wrapper").style.position="relative";
                	 document.getElementById("wrapper").style.width="100%";
                	 document.getElementById("wrapper").style.margin= "auto";
                	 document.getElementById("wrapper").style.height= "1000px";
                	 document.getElementById("login").style.marginLeft="2000px";
                	 document.getElementById("login").style.marginTop= "300px";
                	 document.getElementById("login").style.visibility= "hidden";
                	 document.getElementById("login").style.width= "0%";
                	 document.getElementById("login").style.height="0px";
                	 document.getElementById("login").style.transition="1s";
                	/* document.getElementById("login").style.zIndex="1";  */
                	 window.location.reload(); //새로고침
                	 var asd=0; //안씀
                     //메뉴클릭시 위치
                     if(menubrcnt==0){
                     wd2=screenW/menu.length+10;
                     var list2=new Set();
                     for(var j=0; j<menu.length; j++){
                         var t=wd2*[j];
                         list2.add(t); 
                         
                     }
                     var lcarr2=Array.from(list2);
                     for(let j=0; j<menu.length; j++){
                         menu[j].style.backgroundColor="transparent";
                 		menu[j].style.left=lcarr2[j]+"px";//메뉴위치
                 		menu[j].style.top="0px";
                     }
                     }else{
                     	 wd2=screenW/menu.length+120;
                          var list2=new Set();
                          for(var j=0; j<menu.length; j++){
                              var t=wd2*[j];
                              list2.add(t); 
                              
                          }
                          
                     }
                 });
         });
               
            //mouseoever to enlarge menu text
            for(let i=0; i<menu.length; i++){
                menuover=menu[i].addEventListener("mouseover", function menuover(e){ 
                	//메뉴바 마우스오버(올릴때)
                    menu[i].style.fontSize="3em";
                    menu[i].style.color="black";
                    menu[i].style.width="250px";
                    // 배경색
               		var bkc=["23,45,232","78, 93, 215","95, 107, 216","108, 120, 218"
               		         ,"123, 134, 222","119, 130, 228","157, 164, 223","177, 182, 222"];
               		document.getElementById("wrapper").style.backgroundColor="rgb("+bkc[i]+")";
       
               		var scrh=screen
               		if(menuccnt==0){
                    	document.getElementById("padding").style.marginTop="330px";
               		}else{
               			document.getElementById("padding").style.marginTop="30px" ;
               		}
               		 
                  //remove all preview
                    for(let j=0; j<menu.length; j++){
                    	contentPrev[j].style.display="none";
                    }
                  
                    //show the hoovered preview
                    
                    	if(precnt==0){
                        	contentPrev[i].style.display="block";
                    	}else if(precnt>=1){
                       		contentPrev[i].style.display="none";
                    		
                    	}
                    
                        contentPrev[i].style.opacity="0.5";
                        contentPrev[i].style.position="absolute";
                        //console.log(e);
      					contentPrev[i].style.left=e.clientX+"px";
                        contentPrev[i].style.top="50px";
                        /* contentPrev[i].style.zIndex="0" ; */
                       /*  contentPrev[i].style.width="200px";
                        contentPrev[i].style.height="300px"; */
                        
                    //mouseout
                    menuout=menu[i].addEventListener("mouseout", function menuout(){
                    	for(var j=0; j<menu.length; j++){
                    	contentPrev[i].style.display="none";
                    	}
                    	document.getElementById("wrapper").style.backgroundColor="white";
                        if(menuccnt==0){
                            document.getElementById("padding").style.marginTop="360px";
                       		}else{
                       			document.getElementById("padding").style.marginTop="60px";
                       		}
                       			
                        
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
                    
                    });
                });
            }
            
            //mouseclick to effect on menu
            //and to show its content in main
            	var wd2=screenW/menu.length+10; 
            for(let i=0; i<menu.length; i++){
                menuclick=menu[i].addEventListener("click", function(e){
                	 precnt++;
                     menucnt++;
                     menuccnt++ ;
                     wheelcnt++;
                     menubrcnt2++;
                    menu[i].style.transform="rotate(7deg)" ;
                    var asd=0;
                    //메뉴클릭시 위치
                    if(menubrcnt==0){
                    wd2=screenW/menu.length+10;
                    var list2=new Set();
                    for(var j=0; j<menu.length; j++){
                        var t=wd2*[j];
                        list2.add(t); 
                        
                    }
                    var lcarr2=Array.from(list2);
                    for(let j=0; j<menu.length; j++){
                        menu[j].style.backgroundColor="transparent";
                		menu[j].style.left=lcarr2[j]+"px";//메뉴위치
                    }
                    }else{
                    	 wd2=screenW/menu.length+120;
                         var list2=new Set();
                         for(var j=0; j<menu.length; j++){
                             var t=wd2*[j];
                             list2.add(t); 
                             
                         }
                         var lcarr2=Array.from(list2);
                         for(let j=0; j<menu.length; j++){
                        	 if(j>3){
                        		 menu[j].style.backgroundColor="transparent";
                          		menu[j].style.left=lcarr2[asd]+"px" ;//메뉴위치
                          		menu[j].style.top="50px";
                          		asd++;
                        	 }else{
                             menu[j].style.backgroundColor="transparent" ;
                     		menu[j].style.left=lcarr2[j]+"px";//메뉴위치
                        	 }
                    }
                    }
                    var qwe=0; //메뉴바 두줄 만들기
                    if(menubrcnt2==0){
                   	 var list=new Set();
                        for(var j=0; j<menu.length; j++){
                            var t=wd*[j];
                            list.add(t); 
                            
                        }
                        var lcarr=Array.from(list);
                        for(var k=0; k<menu.length; k++){
                           menu[k].style.left=lcarr[k]+"px";
                                           
                            //console.log(lcarr[k]) ;  
                        }
                        
                        }else{ //다시 복구
                        	 wd2=screenW/menu.length+120;
                             var list2=new Set();
                             for(var j=0; j<menu.length; j++){
                                 var t=wd2*[j];
                                 list2.add(t); 
                                 
                             }
                             var lcarr2=Array.from(list2);
                             for(let j=0; j<menu.length; j++){
                            	 if(j>3){ //j[3] 이상일경우 아래로 내리기 2번째줄
                            		 menu[j].style.backgroundColor="transparent"; // 배경투명.
                              		menu[j].style.left=lcarr2[qwe]+"px";//메뉴위치
                              		menu[j].style.top="50px";
                              		qwe++;
                            	 }else{
                            		 //j[3] 아래일경우 1번째줄
                                 menu[j].style.backgroundColor="transparent" ;
                         		menu[j].style.left=lcarr2[j]+"px";//메뉴위치
                            	 }
                        }     
                        }
                    //메뉴클릭시 메뉴	
                    menu[i].style.backgroundColor="coral";
                    contentPrev[i].style.display="none";
                    document.body.style.overflow="visible";
                    document.removeEventListener("wheel",actWheel);
                    document.getElementById("padding").style.marginTop="60px";
                    document.getElementById("padding").style.visibility="visible";
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
                    contentFull[i].style.zIndex="1";
                    contentFull[i].style.height="600px";
                    contentFull[i].style.width="90%";
                    contentFull[i].style.overflow="auto";
                });   
        }
    });
    </script>
</head>
<body>
	
	<div id="wrapper">
		<a href="/LMS002"><img id="home" src="imgs/logo3.png"></a>
 		<c:set var="power" value="${sessionScope.power }"></c:set>
		<c:choose>
			<c:when test="${power eq null}">
				<img id="logo" src="imgs/plus.png">
 			</c:when>
 			<c:otherwise>
 				<img id="logo">
 			</c:otherwise>
 		</c:choose>
		<div id="padding">
			<c:forEach items="${loadmenu }" var="menulist">
				<h1>${menulist }</h1>
			</c:forEach>
		</div>
		<div id="content">
			<c:forEach items="${loadmenu }" var="menulist">
				<div id="preview">
					<img src="upload/${menulist }/preview.png" />
				</div>
				<div id="fullview">
					<c:import url="upload/${menulist }/fullview.html"
						charEncoding="utf-8"></c:import>
				</div>
			</c:forEach>
		</div>
	</div>

	<div id="login">
		<h2>직원전용 페이지</h2>
		<form action="lmsindex.do" method="post">

			<label for="webid">ID</label> <input type="text" name="webid" /> <br />
			<label for="webpw">PW</label> <input type="text" name="webpw" />

			<div>
				<button type="submit">로그인</button>
			</div>
		</form>
	</div>
</body>
</html>