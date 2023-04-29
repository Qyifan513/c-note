讲稿：
What is attention in deep learning?

Focus on attention：
It is possible to design attention convergence in such a way that a given query is matched to the key, which will lead to the most matching value.
The process is usually to enter the key into the attention score function to get the attention score. Input the output result into the softmax function for operation.The final output is the attention weight we need.

The attention mechanism is a model proposed by Treisman and Gelade that simulates the attention mechanism of the human brain, which can be viewed as a combinatorial function that highlights the effect of a key input on the output by calculating the probability distribution of attention.

- Soft attention mechanisms:  the soft attention mechanism considers all inputs, but instead of giving each input the same weight, it focuses more on certain inputs.
- The hard attention mechanism : The hard attention mechanism is a random process in which attention is paid to only one position information at a certain time, and attention is relatively concentrated.
- Input sequence attention mechanism: Linlin Wang proposes to apply the attention mechanism to the input sequence, and designs a convolutional neural network model based on the multi-layer attention mechanism to automatically identify the parts of the input sentence related to relationship classification. 
- Self-attention, also known as internal attention, usually focuses only on itself and extracts relevant information from it, without using other additional information.

What is the Encoder-Decoder abstraction framework?
Encoder transforms a variable-length input sequence X through a nonlinear transformation into an intermediate semantic representation C:C=f(x1,x2,...,xn).
Decoder's task is to predict and generate the output of moment i based on the intermediate semantic representation of C of the input sequence X and output at the I-1 moment.
The model maps a variable-length input X=(x1,x2,...,xn) to a variable-length output Y=(y1,y2,...,ym).
When you want to predict the next word, use the currently predicted word as query, and each state of the encoder as (key, value). Use query, key, value for attention convergence to find the original text useful for predicting the next word.
### 注意力机制
自主性的与非自主性的注意力提示解释了人类的注意力的方式。
一、只使用非自主性提示。简单地使用参数化的全连接层， 甚至是非参数化的最大汇聚层或平均汇聚层。
二、引入注意力机制。自主性提示：查询（query)。