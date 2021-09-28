import React from 'react'
import { StyleSheet } from 'react-native'




const BlurView = (props)=>{

 
    const {blurNode,radius,style,className,...others} = props

     const r = radius === undefined ? 10 : radius

     const styleObject = typeof style === 'number' ? StyleSheet.flatten(style) : style
     const styleString = 
     `
           
            .blurjjlf {
              background-color: rgba(255, 255, 255, 0.95);
              position: relative;
              width: 100%;
              height: 100%;
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
        <>
          <style  type="text/css">
             {styleString}
          </style>
           <div {...others}  className={`${className} blurjjlf`} style={styleObject}>
                
           </div>

        </>
    )
}


export default BlurView