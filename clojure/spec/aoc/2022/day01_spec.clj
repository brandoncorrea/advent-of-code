(ns aoc.2022.day01-spec
  (:require [speclj.core :refer :all]
            [aoc.2022.day01 :refer :all]))

; https://adventofcode.com/2022/day/1

(def base-case "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")
(def test-data "11223\n6323\n10725\n10761\n3587\n\n1274\n1041\n5566\n1759\n1372\n1619\n2228\n1283\n1981\n1885\n5894\n1321\n6081\n4407\n2992\n\n7184\n2310\n7975\n2752\n7942\n7616\n3622\n1320\n1231\n6191\n\n3069\n10691\n4789\n5329\n6726\n9550\n6188\n3117\n\n17492\n3489\n18055\n\n12369\n21123\n\n2121\n5065\n5377\n1768\n6060\n1256\n1496\n6899\n3569\n3766\n6873\n5490\n2961\n\n6407\n3770\n2823\n5998\n7783\n4194\n1866\n5504\n6550\n7857\n2884\n\n5385\n4621\n2434\n6123\n2159\n6191\n3552\n6871\n\n6531\n4287\n7402\n5634\n3960\n\n4955\n6958\n7652\n7416\n7540\n7990\n1696\n2568\n1040\n3087\n5608\n\n28948\n24385\n\n27643\n31191\n\n8674\n10486\n1765\n1787\n4234\n4187\n7126\n\n6370\n1098\n2071\n4231\n3223\n1456\n3853\n5740\n6327\n2723\n4716\n\n6783\n5772\n4352\n2984\n3483\n2359\n7168\n1581\n6182\n1637\n2601\n4015\n\n12691\n14785\n18295\n\n1035\n5658\n8643\n2693\n6046\n1531\n6174\n8290\n5239\n3430\n\n2510\n1090\n6971\n5314\n6949\n8885\n3334\n9329\n2738\n\n23893\n19568\n19775\n\n4257\n5830\n3972\n4513\n3988\n7674\n1535\n5402\n6257\n1785\n\n12580\n\n3869\n4718\n7144\n7107\n4168\n5713\n6920\n5802\n3226\n1389\n5876\n\n3405\n1630\n3297\n1130\n4787\n2319\n5745\n5744\n2852\n5594\n1641\n2012\n3828\n3717\n2181\n\n6200\n4566\n5973\n4301\n1608\n7023\n6922\n6247\n4402\n6943\n4980\n\n6063\n4381\n3878\n2147\n1437\n2822\n5830\n2453\n3898\n6106\n4618\n1905\n1608\n5115\n1656\n\n7057\n6579\n5295\n6106\n5517\n5560\n2264\n5144\n5623\n1650\n6594\n5828\n\n8444\n4858\n8810\n6516\n5064\n1198\n6087\n8280\n8275\n5471\n\n9667\n26851\n\n5191\n5421\n2865\n1495\n5491\n3406\n1779\n2454\n6648\n6237\n1868\n1313\n\n6885\n8414\n6097\n\n9459\n9028\n2432\n4442\n1721\n8546\n5060\n\n8042\n13365\n7153\n10483\n7147\n\n11597\n1891\n10089\n9866\n11989\n1774\n1386\n\n7690\n5023\n5273\n5257\n1790\n2008\n1100\n4395\n3691\n1270\n\n34927\n32922\n\n22524\n19581\n7007\n\n6204\n5778\n2172\n3231\n5452\n4320\n5110\n1397\n4063\n2370\n6075\n3506\n3764\n2327\n\n1764\n1282\n1837\n3490\n4161\n5852\n5595\n1428\n4863\n1894\n2983\n2336\n4587\n1656\n5178\n\n3987\n6437\n4976\n3214\n2354\n7292\n1167\n4874\n6006\n\n6911\n3746\n6773\n7196\n7615\n1359\n3757\n7858\n5074\n6991\n5915\n\n4952\n6034\n4897\n3990\n5389\n1886\n3544\n7289\n2881\n2402\n6238\n6533\n\n4548\n5600\n5383\n3044\n1113\n6264\n2151\n6527\n7206\n2516\n6959\n7111\n\n5811\n4157\n5365\n3234\n5614\n5556\n3486\n2452\n4304\n4990\n2269\n2944\n2060\n4504\n\n67337\n\n10762\n7277\n4855\n8338\n2555\n4499\n9727\n\n7093\n6258\n\n2117\n6720\n2717\n1336\n2124\n7329\n1182\n4312\n7579\n3997\n\n11769\n4034\n4675\n3409\n5871\n1752\n5233\n\n4359\n7926\n8543\n4196\n3184\n9262\n7649\n\n11423\n1963\n11334\n11792\n\n5951\n5005\n2263\n6667\n1586\n6799\n7104\n5810\n\n1474\n1433\n4979\n5569\n5195\n5467\n5503\n6305\n4527\n5721\n4151\n4965\n3459\n\n1572\n4083\n3559\n3119\n4290\n5019\n1274\n1243\n5732\n3525\n2310\n4945\n1128\n2249\n5974\n\n2324\n6525\n6790\n5283\n4011\n1907\n2385\n6918\n5300\n1177\n5483\n6271\n\n2380\n8204\n6100\n3828\n4024\n5895\n1613\n4301\n4242\n4265\n\n3519\n1809\n8065\n3966\n7829\n1476\n5391\n2276\n5886\n5447\n5325\n\n4424\n3641\n1053\n1843\n2247\n2337\n3572\n1720\n4668\n\n7399\n7282\n3897\n6376\n3540\n5313\n6058\n5209\n5392\n5429\n\n4724\n6793\n7620\n4771\n8430\n2765\n10691\n\n9003\n5417\n7064\n3317\n2271\n3973\n2491\n5203\n\n1978\n5937\n5166\n1587\n5342\n1353\n2506\n3213\n2041\n4374\n3097\n1710\n\n2998\n7694\n2359\n6486\n3319\n7771\n5340\n8062\n6645\n\n6121\n5006\n3579\n12148\n3412\n8373\n10656\n\n2851\n13441\n\n2361\n7577\n8360\n2128\n4313\n6552\n5422\n8627\n\n3435\n11683\n4085\n11581\n3017\n4731\n8645\n\n10115\n9761\n7367\n5257\n10263\n5022\n9674\n6552\n\n4997\n2470\n2855\n1860\n2547\n3060\n1036\n3288\n6338\n5423\n4701\n6740\n2226\n\n2182\n2468\n2724\n4116\n2740\n1677\n1642\n2717\n1604\n2874\n4231\n5637\n5907\n1780\n5585\n\n1425\n5503\n8059\n2459\n2334\n1655\n10561\n\n7278\n5393\n6827\n1776\n6841\n6404\n7090\n7051\n1764\n2107\n5593\n3639\n\n17501\n16452\n11047\n7696\n\n11332\n9288\n13543\n2406\n7699\n5661\n\n9845\n14017\n12535\n7383\n\n4341\n1266\n3942\n2669\n1219\n1987\n5423\n2973\n5656\n4981\n3084\n4455\n1780\n1772\n2947\n\n6183\n2669\n6038\n8553\n12075\n\n3041\n6281\n2661\n1855\n6460\n6508\n6582\n5775\n3895\n1141\n1096\n3572\n\n1458\n2196\n4078\n1940\n2785\n2560\n6964\n5713\n7913\n6951\n2396\n\n1820\n3990\n16654\n15798\n\n1445\n1269\n2821\n5078\n3402\n4371\n6619\n3479\n5353\n1921\n5645\n3800\n\n11876\n15581\n11141\n17267\n\n9397\n8627\n3948\n4177\n6374\n4943\n7444\n4766\n5053\n\n6847\n8418\n2322\n2549\n1334\n5677\n1151\n8407\n\n69814\n\n1529\n5847\n8312\n7219\n4067\n7646\n5212\n5183\n9533\n\n17696\n2661\n7171\n\n8696\n10434\n5330\n6274\n5824\n2386\n10535\n8402\n\n3339\n9444\n3712\n4540\n4296\n4385\n2453\n10416\n\n4225\n7128\n7768\n7085\n1382\n4348\n6967\n1719\n3131\n4060\n3516\n\n3329\n3612\n1093\n4118\n2946\n2250\n1200\n2193\n4142\n3120\n2394\n1217\n1214\n2310\n3690\n\n9634\n10560\n3796\n7011\n10745\n10677\n\n4024\n4466\n6953\n1754\n2261\n6560\n6690\n2671\n6082\n5522\n4024\n\n16675\n17642\n1382\n12630\n\n4454\n4023\n6985\n6880\n5862\n3351\n2861\n5649\n6833\n4668\n2089\n3832\n\n3744\n2151\n3951\n3859\n1900\n2921\n1267\n2132\n4015\n3160\n4747\n4780\n4398\n4160\n5221\n\n18994\n14365\n11726\n\n8313\n16460\n18955\n7491\n\n7558\n1673\n1267\n4825\n4651\n5819\n9798\n\n50633\n\n4542\n1002\n4677\n4874\n5472\n3518\n3642\n3083\n4735\n6769\n5389\n2869\n4223\n\n4275\n4306\n4645\n2360\n4603\n7805\n7964\n8022\n7382\n6504\n\n2452\n9071\n6449\n11056\n7775\n\n8750\n8343\n3753\n11284\n2024\n1088\n\n2376\n8200\n1858\n11313\n10710\n5992\n\n32813\n26299\n\n15734\n8393\n7230\n20011\n\n19297\n21723\n14837\n\n2126\n3511\n6139\n3427\n6135\n5685\n1514\n4338\n4446\n3334\n4417\n1343\n\n5737\n1004\n1168\n4504\n2467\n3431\n3800\n1931\n5287\n4057\n6507\n4662\n1845\n\n6896\n5740\n6075\n5798\n6055\n4309\n5679\n7279\n1311\n4647\n\n3594\n7095\n7139\n6593\n9371\n6162\n1320\n7202\n6216\n\n3592\n1250\n2848\n6524\n1240\n6845\n5263\n1176\n1165\n3641\n5653\n3051\n6168\n\n5535\n4847\n13599\n5746\n5288\n7316\n\n13934\n13998\n25642\n\n4070\n1691\n6012\n5137\n3924\n2272\n4886\n4272\n3467\n5077\n3114\n3794\n5220\n1129\n2113\n\n8763\n11869\n7453\n2318\n10101\n5238\n4663\n\n17968\n21896\n25750\n\n2567\n6997\n8972\n4451\n4917\n4229\n5235\n8327\n2785\n\n6031\n17803\n19811\n\n5995\n3180\n2417\n5245\n2481\n2578\n3879\n4348\n1183\n2027\n1809\n1278\n3428\n2253\n5083\n\n5958\n8942\n6761\n4251\n1630\n2788\n7080\n6954\n4471\n\n4874\n2390\n4410\n1109\n5096\n6956\n1676\n4848\n3521\n5799\n5997\n3748\n5709\n\n3624\n7400\n4652\n3504\n2104\n6861\n4377\n1647\n4293\n7214\n7099\n5289\n\n10481\n1917\n\n3507\n5672\n2015\n2831\n6385\n4068\n5241\n7465\n4759\n5053\n7052\n\n6280\n9794\n4646\n6980\n3720\n\n8585\n9331\n3157\n9319\n7640\n4446\n5594\n1358\n\n6644\n9767\n6051\n6421\n8044\n5769\n1292\n6633\n\n1230\n1380\n4214\n4932\n5426\n3025\n4739\n2440\n4998\n2899\n3845\n2650\n2980\n6266\n\n6378\n1563\n3315\n4910\n1256\n9085\n5390\n10324\n\n8771\n4691\n1164\n1066\n9470\n4868\n9659\n7827\n\n1105\n6108\n4769\n3728\n1575\n4603\n6185\n6376\n5012\n5673\n1280\n5428\n6304\n\n2239\n1560\n5668\n4430\n3985\n4435\n5807\n4135\n5911\n4154\n2544\n2498\n5446\n4814\n\n14668\n11210\n13344\n12364\n9961\n\n11641\n1360\n7500\n4268\n9701\n4171\n2548\n\n1947\n3352\n5709\n4353\n4671\n3119\n2870\n2138\n4595\n2051\n1807\n3416\n3492\n1334\n4695\n\n7970\n8487\n1319\n1471\n7599\n8547\n6998\n1005\n1741\n\n4692\n1989\n2772\n4105\n2154\n1885\n4124\n6762\n5784\n7407\n2898\n\n3169\n2220\n5328\n4295\n8593\n3355\n4605\n6313\n1871\n\n10304\n9352\n7552\n9610\n1175\n10454\n3342\n2821\n\n16100\n9638\n8215\n10806\n3023\n\n29092\n1901\n\n8203\n13092\n10935\n13568\n11032\n2819\n\n4185\n6055\n1638\n4727\n2223\n1707\n2701\n2955\n5282\n1704\n1728\n3464\n4085\n4768\n4239\n\n5205\n7478\n1929\n2900\n5997\n\n34467\n23210\n\n5963\n1701\n6455\n9686\n8353\n5662\n3429\n6921\n9281\n\n4888\n4749\n6983\n4976\n2664\n9637\n5002\n2791\n\n10256\n25711\n22494\n\n3115\n2602\n3274\n4413\n4512\n1994\n3181\n3316\n1755\n2764\n5607\n1058\n4609\n1329\n6055\n\n6595\n4222\n3407\n10124\n1446\n4008\n7234\n\n3194\n4401\n4598\n3461\n2599\n6216\n4501\n1280\n4413\n6073\n1774\n5722\n3007\n3088\n\n10411\n25669\n8871\n\n2613\n2848\n2537\n1277\n5831\n6144\n5639\n6685\n6095\n3826\n1796\n6333\n6555\n\n1310\n6643\n9862\n2064\n1697\n4078\n3647\n6155\n\n4361\n2370\n2349\n2015\n4278\n4873\n5165\n4172\n3229\n6081\n5611\n4981\n5538\n4877\n3416\n\n4484\n6999\n7901\n7691\n2688\n5054\n5847\n10641\n\n49205\n\n4445\n3962\n4702\n5865\n4458\n4673\n4979\n2816\n4194\n5485\n1370\n1414\n1938\n6069\n1713\n\n1272\n5551\n6047\n1084\n1476\n6923\n3815\n2695\n3753\n4342\n4076\n7109\n\n1166\n10620\n2255\n15911\n\n3776\n31838\n\n5462\n7846\n10506\n10139\n\n5095\n7569\n5193\n2026\n7823\n7835\n8264\n3499\n9567\n\n8657\n6625\n5734\n6420\n3489\n8213\n2147\n7071\n3228\n6418\n\n10360\n1069\n14776\n6090\n\n5317\n3597\n5311\n2456\n1009\n3954\n5518\n3283\n3619\n4970\n5877\n4643\n5428\n2472\n1800\n\n9343\n8166\n3967\n4650\n6978\n1809\n9866\n1354\n\n5664\n5951\n\n18203\n7380\n2701\n16860\n\n2995\n2739\n5498\n1567\n8326\n2770\n4838\n\n10006\n1510\n3844\n1706\n8009\n11790\n7550\n\n1185\n2494\n1299\n4168\n6869\n4108\n4941\n5636\n2668\n4842\n3448\n3087\n3871\n\n4568\n21522\n11228\n\n1210\n5132\n6540\n8377\n5968\n5358\n4232\n4710\n\n6603\n23736\n\n4328\n2190\n4021\n4316\n4760\n3010\n5604\n4746\n5843\n5327\n2718\n4956\n3167\n3359\n\n8760\n6848\n7827\n7235\n2491\n6362\n7344\n4841\n4454\n8604\n\n8394\n5794\n13797\n15870\n4818\n\n8412\n14825\n16385\n11468\n\n29542\n\n6924\n5318\n6833\n3875\n6931\n3650\n2849\n2068\n7369\n1375\n2375\n4576\n\n2269\n5568\n4133\n3853\n1996\n5885\n1074\n3356\n5187\n6079\n1522\n5220\n1704\n2942\n1641\n\n14866\n9313\n23116\n\n13359\n13222\n15441\n14439\n16050\n\n8511\n10467\n8505\n2880\n4654\n6594\n3942\n1306\n\n6483\n7197\n4990\n6774\n\n8594\n7425\n5701\n9526\n2538\n9519\n8284\n8558\n9647\n\n1181\n7034\n13744\n6912\n9743\n8735\n\n5076\n7046\n5565\n2810\n1461\n4916\n3777\n5174\n1842\n6263\n4151\n6307\n\n6262\n11239\n\n2639\n3859\n6504\n4947\n6810\n6805\n3288\n3042\n5873\n6339\n2931\n4332\n1707\n\n1834\n2381\n5243\n5769\n3444\n2755\n4929\n1520\n3791\n2443\n1521\n6059\n3943\n5845\n\n19725\n18762\n2318\n11981\n\n7867\n10660\n2834\n13236\n1524\n7225\n\n1377\n2138\n2955\n1407\n3971\n1872\n1293\n6090\n1203\n6798\n2729\n3360\n\n12399\n5994\n7732\n12299\n12160\n\n10151\n19182\n18060\n19397\n\n34075\n25670\n\n5145\n6043\n5241\n2001\n6063\n1342\n4769\n6629\n7465\n3500\n4873\n\n4825\n5192\n1670\n5946\n8053\n2622\n1436\n5977\n4523\n4415\n5831\n\n7035\n3322\n7624\n1840\n2078\n6420\n6273\n4362\n4874\n7712\n5714\n\n3644\n4526\n2940\n7904\n7620\n6260\n4794\n3705\n3585\n3033\n\n5391\n6000\n3398\n3922\n4655\n6747\n6505\n3402\n2082\n1856\n6626\n\n6085\n5246\n3072\n8802\n3666\n6219\n7612\n4531\n\n5420\n2366\n3861\n5686\n2737\n6276\n2292\n6004\n6195\n1605\n1639\n7004\n\n4932\n2314\n2297\n1611\n4624\n7495\n3485\n6580\n1751\n5170\n6100\n\n9273\n11201\n6597\n3958\n11219\n8899\n9413\n\n28386\n26100\n\n3170\n2290\n6393\n2973\n5677\n4855\n1937\n4071\n2830\n2344\n4708\n3775\n2780\n5562\n\n11208\n4958\n7770\n10314\n8593\n11973\n6000\n\n19570\n24273\n20898\n\n1972\n12111\n8510\n1145\n\n12217\n13432\n\n7383\n1407\n5216\n8061\n10559\n8810\n1385\n\n2300\n3845\n4200\n3033\n2758\n2464\n1543\n1216\n4980\n4409\n3881\n5162\n1743\n2350\n4386\n\n5339\n2610\n10101\n3159\n15809\n\n6064\n3176\n6116\n1092\n4494\n1245\n4343\n2704\n5405\n5426\n5126\n4722\n1609\n4367\n2280\n\n16523\n23950\n11677\n\n9674\n1499\n11422\n13298\n9949\n10616\n\n3895\n9314\n12341\n8416\n\n1949\n9055\n3289\n5458\n9902\n7137\n6167\n5111\n\n2141\n2700\n2221\n7184\n6103\n4030\n3695\n4116\n3358\n6650\n5498\n1608\n\n3900\n5189\n3383\n5800\n5109\n2383\n1001\n6074\n1110\n5187\n5430\n3448\n1899\n5865\n1098\n\n8948\n2222\n8881\n1948\n6993\n4242\n4588\n7172\n\n6514\n3993\n9681\n6992\n6150\n10477\n5089\n8951\n\n1714\n7959\n12561\n13204\n13321\n3506\n\n4979\n3299\n1108\n5065\n\n5536\n8474\n8551\n5400\n1405\n10623\n5028\n9292\n\n1199\n4551\n4953\n2814\n4224\n6361\n3457\n3640\n3139\n4825\n2001\n1432\n4116\n3688\n\n13664\n10207\n6028\n3098\n4410\n4175\n\n5623\n3796\n2402\n4038\n2083\n2761\n1806\n3806\n1704\n1905\n1550\n6133\n4524\n\n3052\n3739\n3842\n7695\n8135\n3738\n4717\n3232\n8761\n\n4498\n4685\n7377\n2806\n5031\n3386\n1609\n7810\n3717\n2535\n6173\n\n15301\n1343\n\n6134\n\n3331\n8838\n18585\n2670\n\n10770\n4959\n8095\n1497\n1627\n4809\n5857\n10329\n\n8734\n3895\n4301\n5958\n1740\n10403\n8830\n\n3531\n13028\n12682\n\n19031\n\n14044\n\n2867\n1941\n5744\n9099\n3583\n1719\n3917\n2737\n4593\n\n4474\n2684\n9230\n7981\n3032\n4811\n9558\n8513\n\n23797\n27967\n\n9143\n8743\n9120\n4760\n1985\n7971\n7476\n10415\n\n24714\n13638\n\n13753\n13010\n12301\n15112\n13584\n\n1467\n2681\n4482\n3424\n7161\n7828\n6262\n5660\n6950\n5807\n5109\n\n3023\n5008\n5278\n1131\n1563\n6917\n1553\n2406\n3173\n3255\n2772\n1427\n1930")

(describe "AoC Day 1"

  (context "Part 1"
    (it "no elves"
      (should= 0 (part-1 "")))

    (it "one elf with no calories"
      (should= 0 (part-1 "0")))

    (it "one elf with one calorie"
      (should= 1 (part-1 "1")))

    (it "one elf with two calories"
      (should= 2 (part-1 "2")))

    (it "two elves with one calorie"
      (should= 1 (part-1 "1\n\n1")))

    (it "two elves with different calories"
      (should= 2 (part-1 "1\n\n2")))

    (it "one elf with two rations"
      (should= 3 (part-1 "1\n2")))

    (it "base case"
      (should= 24000 (part-1 base-case)))

    (it "solves test data"
      (should= 72511 (part-1 test-data))))

  (context "Part 2"
    (it "no elves"
      (should= 0 (part-2 "")))

    (it "one elf with no calories"
      (should= 0 (part-2 "0")))

    (it "one elf with one calorie"
      (should= 1 (part-2 "1")))

    (it "one elf with two calories"
      (should= 2 (part-2 "1\n1")))

    (it "two elves"
      (should= 3 (part-2 "1\n\n2")))

    (it "three elves"
      (should= 6 (part-2 "1\n\n2\n\n3")))

    (it "four elves"
      (should= 9 (part-2 "1\n\n2\n\n3\n\n4")))

    (it "base case"
      (should= 45000 (part-2 base-case)))

    (it "test data"
      (should= 212117 (part-2 test-data)))))
