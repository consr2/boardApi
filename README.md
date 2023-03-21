# board2
발전된 게시판 사이트 ver2

-----------------------------------------------  
3-21일지  
  .  
1. 인터셉터의 변경이 필요하다.  
1-1. 현재는 세션이 있고 세션의 정보가 eunm클래스에 있는 정보이면 권한이 인증되서 실행되는 방법이다.  
1-2. 문제점은 해당 방식으로 비 로그인시 좋아요 당사자 체크가 하기 어렵다. 또한 필요한 조건이 생길 때 마다  
메서드 혹은 클래스를 추가해줘야 하는 방식이여서 효율성이 떨어진다.  
  
  정리를 하면 
  1. 인터셉터로 권한이 없는 사용자의 메서드 접근을 막는다.  
  2. 비 로그인시 guest 권한을 줘야한다. (이럴시 service 로직에서 다시 유저를 판독해야하는 일이 생겨버림....)  
  2-1. 그렇다면 인터셉터 측에서 모든 결과를 처리하고 해당 메서드로 연결을 해주는 것이 깔끔 할 것이다.  
  2-2. 인터셉터를 어떻게 구성해야 하는가....  
  .  
  .  
  .  
  3. 인터셉터 재구성  
  3-1. 세션은 로그인을 할 시 생성된다.  
  3-2. 세션의 정보는 아이디와 권한이다.  
  3-3. 해결해야하는 점 : 글을 쓸 떄는 권한이 있는 사용자만 메서드 접근, 읽을 때 권한을 guest로 설정(좋아요 당사자 체크)
  3-4. 인터셉터에서 확인은 세션으로 하고 확인 후 header에 정보를 추가하여 사용?(로그인 비로그인 모두 헤더의 정보를 가지게 됨)
