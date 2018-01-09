# HB6_2017_Project2
권미란 김도진 김성식 전대일 학원프로젝트 최종코드
<p>1.요구사항: 비트캠프 신규 분점을 위한 마케팅 웹과 웹기반 학원관리시스템(LMS) 개발</p>
<p>(교육 목적상 부트스트랩, 스프링 등 외부 FX 사용하지 않고 직접 MVC패턴을 사용해서 개발)</p>
<p>2.개발 기간:</p> 
<ul>
<li>요구사항 분석 및 문서 제출: 2주</li>
<li>실제 코딩기간: 딱 8일 </li>
</ul> 
<p>3. 노트</p>
<ul>
<li>매우 짧은 기간에 기능 구현에만 집중하여 파일 정리 및 코드 refactoring 이 필요한 상태이나, 본 리포지토리는 현 상태로 유지하고 프로젝트 참여자들이 원할 경우 각자 refactoring 및 수정/보완해서 개인 포트폴리오에 사용하기로 함.</li>
<li>개발 과제 요약은 첨부한 프로젝트 발표자료 참조</li>
<li>리포지토리의 프로젝트중 “LMS002” 가 최종본</li>
<li>실행환경: 톰켓 7.0, 오라클 10</li>
<li>Controller 패키지 바로 아래 OutsetController 코드의 file I/O를 통해 홈페이지 메뉴를 불러오는데, 해당 코드는 톰캣이 c 드라이브 바로 아래 설치된 것을 가정합니다. 톰켓이 다른 곳에 설치되어 있다면 변경해야 함.</li> 
<li>Web Inf 아래 lib 폴더는  gitignore 되어 있습니다. 필요한 lib 파일은 다음과 같습니다: ojdbc14.jar, jstl-1.2.jar (taglibs-standard-jstlel-1.2.5.jar, standard-1.1.2.jar)</li>    
</ul>
