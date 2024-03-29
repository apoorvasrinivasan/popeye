import{u as d,c as m,a as e,w as c,b as l,v as n,d as o,_ as u,e as g,o as f}from"./index-PsjdFMY_.js";const x={class:"flex min-h-full flex-col justify-center px-6 py-12 lg:px-8"},p=e("div",{class:"sm:mx-auto sm:w-full sm:max-w-sm"},[e("img",{class:"mx-auto h-10 w-auto",src:u}),e("h2",{class:"mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900"},"Login in to your account")],-1),w={class:"mt-10 sm:mx-auto sm:w-full sm:max-w-sm"},_=e("label",{for:"email",class:"block text-sm font-medium leading-6 text-gray-900"},"Email address",-1),b={class:"mt-2"},h=e("div",{class:"flex items-center justify-between"},[e("label",{for:"password",class:"block text-sm font-medium leading-6 text-gray-900"},"Password"),e("div",{class:"text-sm"},[e("a",{href:"#",class:"font-semibold text-indigo-600 hover:text-indigo-500"},"Forgot password?")])],-1),y={class:"mt-2"},v=e("div",null,[e("button",{type:"submit",class:"flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"},"Sign in")],-1),k=e("p",{class:"mt-10 text-center text-sm text-gray-500"},[g(" Not a member? "),e("a",{href:"#",class:"font-semibold leading-6 text-indigo-600 hover:text-indigo-500"},"Sign up")],-1),B={__name:"Login",setup(S){const a=d();let s={};function r(){console.log("logged in"),console.log(s),a.login(s)}return(V,t)=>(f(),m("div",x,[p,e("div",w,[e("form",{class:"space-y-6",onSubmit:c(r,["prevent"])},[e("div",null,[_,e("div",b,[l(e("input",{id:"email","onUpdate:modelValue":t[0]||(t[0]=i=>o(s).username=i),type:"text",autocomplete:"email",required:"",class:"pl-1 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"},null,512),[[n,o(s).username]])])]),e("div",null,[h,e("div",y,[l(e("input",{id:"password","onUpdate:modelValue":t[1]||(t[1]=i=>o(s).password=i),name:"password",type:"password",autocomplete:"current-password",required:"",class:"pl-1 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"},null,512),[[n,o(s).password]])])]),v],32),k])]))}};export{B as default};
