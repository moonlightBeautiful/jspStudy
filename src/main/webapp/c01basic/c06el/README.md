# servlet
简介
    是jsp写法更加简洁，{表达式}
el表达式内置对象
    1.pageContext cookie initParam
    2.pageScope requestScope sessionScope applicationScope
    3.param.参数      获取单个参数 
      paramValues.数组[index]     获取数组参数
    4.header  headerValues 
访问4大作用域保存的数据
    ${属性 }   
    寻找值的顺序：page->request->session->application
取对象、集合、map类型的值
    ${对象.属性 }
    ${集合[index] }
    ${map.get("key") }
支持 算数运算符，关系运算符，逻辑运算符；三目运算符；Empty 关键字；