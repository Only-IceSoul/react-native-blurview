import React, { useMemo } from 'react'
import { StyleSheet } from 'react-native'




const BlurView = (props)=>{
   
     
    const {blurNode,radius,style,className,children,...others} = props
     const r = radius === undefined ? 10 : radius
   
     const styleObject = useMemo(()=>{
       if (typeof style === 'number') return StyleSheet.flatten(style) 
       if(Array.isArray(style)){
          var styleJs = {}
          style.forEach((v)=>{
            if(typeof v === 'number'){
               let ss = StyleSheet.flatten(style) 
               Object.assign(styleJs,ss)
            }else{
              Object.assign(styleJs,v)
            }
          })

          return styleJs
       }
       return style
     },[style])

     const styleString = 
     `
           
            .blurjjlf {
              background-color: rgba(255, 255, 255, 0.95);

            }
            
            @supports (-webkit-backdrop-filter: none) or (backdrop-filter: none) {
              .blurjjlf {
                -webkit-backdrop-filter: blur(${r}px);
                backdrop-filter:  blur(${r}px);
                background-color: transparent;  
              }
            }
    `

    return(
        <div {...others} style={styleObject}>
          <style  type="text/css">
             {styleString}
          </style>
           <div   className={`${className} blurjjlf`}  style={{width:'100%',height:'100%',position:'absolute',left:0,top:0}}>
                
           </div>
          {children}
        </div>
    )
}


export default BlurView